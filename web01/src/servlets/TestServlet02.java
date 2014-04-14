package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * 애노테이션으로 서블릿 등록하기
 */
/* @WebServlet
 * - 서블릿을 선언 + URL 매핑 
 * - value 속성: URL 매핑 정보
 *    문법) value=String[]
 *    사용법1) value={"url1","url2"}
 *    사용법2) value={"url1"}
 *    사용법3) value="url1"
 * - value 속성만 값을 설정할 것이라면 => 속성 이름 생략해도 된다.
 */
//@WebServlet(value={"/test/test02.bit","/test/test0202.bit"})
//@WebServlet(value={"/test/test02.bit"})
//@WebServlet(value="/test/test02.bit")
@WebServlet("/test/test02.bit") 
public class TestServlet02 extends HttpServlet {
  private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(
			HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>test01</title></head>");
		out.println("<body><h1>test02-애노테이션 사용</h1></body></html>");
	}
}

















