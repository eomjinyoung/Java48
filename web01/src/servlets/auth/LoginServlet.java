package servlets.auth;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/auth/login.bit")
@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {
	@Override
	protected void doGet(
			HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
		try {
			RequestDispatcher rd = 
					request.getRequestDispatcher("/auth/login.jsp");
			rd.forward(request, response);
			
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPost(
			HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
		try {
			System.out.println("email=>" + request.getParameter("email"));
			System.out.println("password=>" + request.getParameter("password"));
			System.out.println("saveEmail=>" + request.getParameter("saveEmail"));
			
			response.sendRedirect("../subject/list.bit?pageNo=1&pageSize=10");
			
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}
















