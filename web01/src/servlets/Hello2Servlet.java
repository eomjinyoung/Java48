package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

@SuppressWarnings("serial")
public class Hello2Servlet extends GenericServlet {
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
}





















