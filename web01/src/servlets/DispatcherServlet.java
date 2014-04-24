package servlets;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controls.PageController;

@WebServlet("*.bit")
@SuppressWarnings("serial")
public class DispatcherServlet extends HttpServlet {
	
	@Override
	protected void service(
			HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
		// 0) 출력 콘텐츠의 문자 집합 지정
		response.setContentType("text/html;charset=UTF-8");
		
	  // 1) 서블릿 경로를 알아낸다.
		String servletPath = request.getServletPath();
		
		// 2) 서블릿 경로에 대해 페이지 컨트롤러를 찾는다.
		// - 가정: 모든 페이지 컨트롤러는 DAO처럼 ServletContext에 보관되어 있다.
		ServletContext sc = this.getServletContext();
		PageController pc = (PageController) sc.getAttribute(servletPath);
		
		// 3) 페이지 컨트롤러가 사용할 파라미터 값 준비 
		HashMap<String,Object> model = new HashMap<String,Object>();
		
		// request에 들어 있는 파라미터 값을 model로 복사한다.
		Enumeration<String> paramNames = request.getParameterNames();
		String paramName = null;
		while (paramNames.hasMoreElements()) {
			paramName = paramNames.nextElement();
			model.put(	paramName, 	request.getParameter(paramName));
		}
		
		// * HttpSession 객체를 주입
		HttpSession session = request.getSession();
		injectHttpSession(pc, session);
		
		// 4) 페이지 컨트롤러를 호출한다.
		String viewUrl = pc.execute(model);
		
		// 5) model 객체에 담겨있는 값을 request에 복사한다.
		for (String name : model.keySet()) {
			if (!name.equals("sessionMap") && !name.equals("cookies")) {
				request.setAttribute(name, model.get(name));
			}
		}
		
		// * sessionMap이 있다면 HttpSession에 보관
		@SuppressWarnings("unchecked")
    Map<String,Object> sessionMap = 
				(Map<String,Object>) model.get("sessionMap");
		if (sessionMap != null) {
			for (Entry<String,Object> entry : sessionMap.entrySet()) {
				session.setAttribute(entry.getKey(), entry.getValue());
			}
		}
		
		// * cookies가 있다면 응답헤더에 추가
    @SuppressWarnings("unchecked")
    List<Cookie> cookies = (List<Cookie>) model.get("cookies");
    if (cookies != null) {
    	for (Cookie cookie : cookies) {
    		response.addCookie(cookie);
    	}
    }

		// View로 실행 위임.		
		if (viewUrl.startsWith("redirect:")) {
			response.sendRedirect(viewUrl.substring(9));
		} else {
			// 6) 페이지 컨트롤러가 리턴한 뷰 URL을 인클루드 한다.
			RequestDispatcher rd = request.getRequestDispatcher(viewUrl);
			rd.include(request, response);
		}
	}
	
	private void injectHttpSession(Object obj, HttpSession session) {
		try {
			Class<?> clazz = obj.getClass(); // 객체의 클래스 정보를 가져온다.
			Method[] methods = clazz.getMethods(); // 클래스의 메서드 목록을 얻는다.
			
			for (Method m : methods) {
				
				// 목록에서 setXXX() 셋터 메서드를 찾는다.
				if (m.getName().startsWith("set")) {
					
					// 셋터 메서드의 파라미터 타입을 알아낸다.
					Class<?> parameterType = m.getParameterTypes()[0];
					
					// 파라미터의 타입이 HttpSession 클래스인지 확인
					if (parameterType == HttpSession.class) {
						m.invoke(obj, session);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}



















