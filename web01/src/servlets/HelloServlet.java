package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class HelloServlet implements javax.servlet.Servlet {
	ServletConfig config;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
	  System.out.println("init() 호출됨...");
	  this.config = config;
	}
	
	@Override
	public void destroy() {
	  System.out.println("destroy() 호출됨...");
	}
	
	@Override
	public void service(ServletRequest request, ServletResponse response)
	    throws ServletException, IOException {
		System.out.println("service() 호출됨...");
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body><h1>오호라.. 출력되는구나. T.T</h1></body>");
		out.println("</html>");
	}
	
	@Override
	public String getServletInfo() {
	  return "HelloServlet";
	}
	
	@Override
	public ServletConfig getServletConfig() {
	  return this.config;
	}
}





















