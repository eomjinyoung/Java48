package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * 입력 파라미터 값 꺼내기
 * - GET =>
 * 			GET URL?파라미터명=값&파라미터명=값 HTTP/1.1
 * 			...(헤더정보)
 * 			(엔터)
 * 
 * - POST =>
 * 			POST URL HTTP/1.1
 * 			...(헤더정보)
 * 			(엔터)
 * 			파라미터명=값&파라미터명=값
 * 
 *  - GET/POST 상관없이 값을 꺼낼 수 있다.
 *     => getParameter("파라미터명") 호출 
 */
@WebServlet("/test/test03.bit") 
public class TestServlet03 extends HttpServlet {
  private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(
			HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
		// 요청 정보에서 파라미터 값 꺼내기
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		
		// 클라이언트에게 출력하기 
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>test03</title></head>");
		out.println("<body><h1>test03-요청 파라미터 값 꺼내기 </h1>");
		out.println("과목명: " + title + "<br>");
		out.println("내용: " + description + "<br>");
		out.println("</body></html>");
	}
}

















