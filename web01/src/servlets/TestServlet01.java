package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * 출력하기
 */
public class TestServlet01 extends HttpServlet {
	@Override
	protected void doGet(
			HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	  // 1) 출력할 콘텐츠의 타입을 지정
		// - setContentType("MIME타입;문자집합");
		// - MIME: Multipurpose Internet Mail Extensions
		//					데이터의 형식을 선언
		response.setContentType("text/html;charset=UTF-8");
		
		/* 출력 한글 처리 
		 * - 출력 데이터가 한글이 포함되어 있다면, 반드시 문자집합을 지정한다.
		 * - 기본 출력 문자 집합 = ISO-8859-1
		 * - 지정하지 않으면 => ISO-8859-1에 없는 문자는 ?로 바뀌어 출력된다.
		 * - 출력 스트림을 얻기 전에 설정해야 적용된다.
		 */
		
		
		// 2) 출력을 수행할 스트림 객체를 얻는다.
		PrintWriter out = response.getWriter();
		//response.setContentType("text/html;charset=UTF-8");
		out.println("<html><head><title>test01</title></head>");
		out.println("<body><h1>test01-출력하기</h1></body></html>");
		
	}
}

















