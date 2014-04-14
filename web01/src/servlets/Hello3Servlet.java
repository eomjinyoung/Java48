package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class Hello3Servlet extends HttpServlet {
	
	/* GET
	 * - 요청이 발생하는 경우: 
	 *   => 웹 브라우저 주소창에 URL입력 후 엔터
	 *   => 화면에서 링크 클릭 
	 * - Servlet Container(톰캣) 
	 *   => service() 호출
	 *   => HttpServlet에 추가된 service() 호출
	 *    => 요청 방식에 따라 doGet(), doPost(), doHead(), doDelete() 등 호출  
	 */
	@Override
	public void doGet(
			HttpServletRequest request, 
			HttpServletResponse response)
	    throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body><h1>GET 요청!!</h1></body>");
		out.println("</html>");
	}
	
	/* POST
	 * - 요청 발생 조건
	 *   => <form method="post">에서 요청한 경우 
	 *   => 자바 스크립트의 AJAX에서 POST 요청 시
	 * - 톰캣 서버 => service() => HttpServlet에 추간된 service() => doPost()
	 */
	@Override
	protected void doPost(
			HttpServletRequest request, 
			HttpServletResponse response)
	    throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body><h1>POST 요청!!</h1></body>");
		out.println("</html>");
	}

}





















