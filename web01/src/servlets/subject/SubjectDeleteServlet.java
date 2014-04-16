package servlets.subject;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SubjectDao;

/* Refresh
 * - 일정시간 후 서버에 지정된 URL을 요청하게 만듦
 * - 1) 응답 헤더에 리프래시 정보 심기
 * - 2) HTML 헤더에 리프래시 정보 심기 
 * 
 * Redirect
 * - 클라이언트에게 다시 요청할 주소를 알려줌.
 * - 경과 시간 지정 불가!
 * - 콘텐츠를 보내지 않는다.
 */

@WebServlet("/subject/delete.bit")
@SuppressWarnings("serial")
public class SubjectDeleteServlet extends HttpServlet {
	@Override
	protected void doGet(
			HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		// 1) 응답 헤더에 Refresh 명령어 심기 
		//response.setHeader("Refresh", "1;url=list.bit?pageNo=1&pageSize=10");
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>과목삭제</title>");
		
		// 2) 응답 내용에 Refresh 명령어 심기
		//out.println("<meta http-equiv='Refresh'"
		//		+ " content='1;url=list.bit?pageNo=1&pageSize=10'>");
		out.println("</head><body>");
		
		try {
			out.println("<h1>과목 삭제 결과</h1>");
			
			SubjectDao dao = (SubjectDao)this.getServletContext()
					.getAttribute("subjectDao");
			
			int no = Integer.parseInt(request.getParameter("no"));
			
			dao.delete(no);
			
			out.println("삭제 성공!");
			
			// 3) Redirect 처리
			// - 콘텐츠를 출력하지 않기 때문에 => 이전에 출력한 내용은 취소된다.
			response.sendRedirect("list.bit?pageNo=1&pageSize=10");
			
		} catch (Throwable e) {
			out.println("오류 발생 했음!");
			e.printStackTrace();
		}
		out.println("</body></html>");
	}
}
















