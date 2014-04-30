package sems.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
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

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import sems.controls.PageController;
import sems.listeners.ContextLoaderListener;

@WebServlet("*.bit")
@SuppressWarnings("serial")
public class DispatcherServlet extends HttpServlet {
	
	@Override
	protected void service(
			HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
		try {
			response.setContentType("text/html;charset=UTF-8");
			String servletPath = request.getServletPath();
			
			PageController pc = (PageController) ContextLoaderListener
																.applicationContext.getBean(servletPath);
			
			injectServletContext(pc); 
			
			HttpSession session = request.getSession();
			injectHttpSession(pc, session);
					
			HashMap<String,Object> model = new HashMap<String,Object>();
			
			if (ServletFileUpload.isMultipartContent(request)) {
				prepareMultipartRequestData(model, request);
			} else {
				prepareGeneralRequestData(model, request);
			}
			
			String viewUrl = pc.execute(model);
			
			for (String name : model.keySet()) {
				if (!name.equals("sessionMap") && !name.equals("cookies")) {
					request.setAttribute(name, model.get(name));
				}
			}
			
			@SuppressWarnings("unchecked")
	    Map<String,Object> sessionMap = 
					(Map<String,Object>) model.get("sessionMap");
			if (sessionMap != null) {
				for (Entry<String,Object> entry : sessionMap.entrySet()) {
					session.setAttribute(entry.getKey(), entry.getValue());
				}
			}
			
	    @SuppressWarnings("unchecked")
	    List<Cookie> cookies = (List<Cookie>) model.get("cookies");
	    if (cookies != null) {
	    	for (Cookie cookie : cookies) {
	    		response.addCookie(cookie);
	    	}
	    }
	
			if (viewUrl.startsWith("redirect:")) {
				response.sendRedirect(viewUrl.substring(9));
			} else {
				RequestDispatcher rd = request.getRequestDispatcher(viewUrl);
				rd.include(request, response);
			}
		} catch (Throwable ex) {
			StringWriter out = new StringWriter();
			ex.printStackTrace(new PrintWriter(out));
			
			request.setAttribute("error", out.toString());
			RequestDispatcher rd = request.getRequestDispatcher("/error.jsp");
			rd.forward(request, response);
		}
	}
	
	private void injectHttpSession(Object obj, HttpSession session) 
			throws Exception {
		Class<?> clazz = obj.getClass(); // 객체의 클래스 정보를 가져온다.
		Method[] methods = clazz.getMethods(); // 클래스의 메서드 목록을 얻는다.
		for (Method m : methods) {
			if (m.getName().startsWith("set")) {
				Class<?> parameterType = m.getParameterTypes()[0];
				if (parameterType == HttpSession.class) {
					m.invoke(obj, session);
				}
			}
		}
	}
	
	private void injectServletContext(Object obj) throws Exception {
		Class<?> clazz = obj.getClass(); 
		Method[] methods = clazz.getMethods();
		for (Method m : methods) {
			if (m.getName().startsWith("set")) {
				Class<?> parameterType = m.getParameterTypes()[0];
				if (parameterType == ServletContext.class) {
					m.invoke(obj, this.getServletContext());
				}
			}
		}
	}
	
	private void prepareGeneralRequestData(
			Map<String,Object> model, HttpServletRequest request) {
		Enumeration<String> paramNames = request.getParameterNames();
		String paramName = null;
		while (paramNames.hasMoreElements()) {
			paramName = paramNames.nextElement();
			model.put(	paramName, 	request.getParameter(paramName));
		}
	}
	
	private void prepareMultipartRequestData(
			Map<String,Object> model, HttpServletRequest request)
			throws Exception {
		DiskFileItemFactory fileFactory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(fileFactory);
		List<FileItem> items = upload.parseRequest(request);
			
		for (FileItem item : items) {
			if (item.isFormField()) { // 일반 데이터
				model.put(item.getFieldName(), item.getString("UTF-8"));
			} else { // 파일 데이터 
				model.put(item.getFieldName(),	item);
			}
		}
	}
	
}



















