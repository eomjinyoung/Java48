package servlets;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		// 4) 페이지 컨트롤러를 호출한다.
		String viewUrl = pc.execute(model);
		
		// 5) model 객체에 담겨있는 값을 request에 복사한다.
		for (String name : model.keySet()) {
			request.setAttribute(name, model.get(name));
		}
		
		// 6) 페이지 컨트롤러가 리턴한 뷰 URL을 인클루드 한다.
		RequestDispatcher rd = request.getRequestDispatcher(viewUrl);
		rd.include(request, response);
	}
}



















