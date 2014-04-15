package servlets;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import dao.MysqlSubjectDao;
import util.DBConnectionPool;

/* 서블릿
 * - 생성 시점: 최소로 클라이언트가 요청했을 때
 *   => 클라이언트가 요청하지 않으면 생성되지 않는다.
 */

/* 초기화 서블릿
 * - 클라이언트 요청을 처리하는 용도로 사용하지 않는다.
 * - 다른 서블릿을 위해 리소스를 준비한다.
 * - URL 매핑하지 말 것!
 */
@SuppressWarnings("serial")
public class AppInitServlet extends GenericServlet {
	DBConnectionPool dbConnectionPool;
	
	public AppInitServlet() {
		System.out.println("AppInitServlet 생성됨.");
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
	  // 기존의 메서드를 그대로 사용할 것이라면 다음과 같이 
		// 오버라딩 하기 전의 원래 메서드를 호출하라!
		super.init(config); //super의미? 오버라이딩 전의..
		
		//다른 서블릿을 위한 공통 자원을 준비
		dbConnectionPool = new DBConnectionPool();
		MysqlSubjectDao subjectDao = new MysqlSubjectDao();
		subjectDao.setDBConnectionPool(dbConnectionPool);
		
		ServletContext sc = config.getServletContext();
		sc.setAttribute("subjectDao", subjectDao);
	}
	
	@Override
	public void destroy() {
	  super.destroy();
	  
	  dbConnectionPool.closeAll();
	}
	
	@Override
	public void service(ServletRequest arg0, ServletResponse arg1)
	    throws ServletException, IOException {
	}

}







