package servlets.subject;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.DBConnectionPool;
import vo.SubjectVo;
import dao.MysqlSubjectDao;

@WebServlet("/subject/update.bit")
@SuppressWarnings("serial")
public class SubjectUpdateServlet extends HttpServlet {
	@Override
	protected void doGet(
			HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>과목변경</title></head><body>");
		
		try {
			out.println("<h1>과목 변경 결과</h1>");
			
			DBConnectionPool dbConnectionPool = new DBConnectionPool();
			MysqlSubjectDao dao = new MysqlSubjectDao();
			dao.setDBConnectionPool(dbConnectionPool);
			
			SubjectVo vo = new SubjectVo();
			vo.setNo(Integer.parseInt(request.getParameter("no")));
			vo.setTitle(request.getParameter("title"));
			vo.setDescription(request.getParameter("description"));
			
			dao.update(vo);
			
			out.println("변경 성공!");
			
		} catch (Throwable e) {
			out.println("오류 발생 했음!");
			e.printStackTrace();
		}
		out.println("</body></html>");
	}
}
















