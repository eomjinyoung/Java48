package servlets.auth;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/* 로그아웃
 * - 세션 객체를 무효화시킨다.
 */

@WebServlet("/auth/logout.bit")
@SuppressWarnings("serial")
public class LogoutServlet extends HttpServlet {
	@Override
	protected void doGet(
			HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
		request.getSession().invalidate();
		response.sendRedirect("login.bit");
	}
}
















