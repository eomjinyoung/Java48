package listeners;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import util.DBConnectionPool;
import controls.SubjectDetailControl;
import controls.SubjectListControl;
import dao.MysqlSubjectDao;
import dao.MysqlUserDao;

/* PageController를 ServletContext에 보관함.
 * - PageController가 필요로 하는 의존 객체를 주입한 후에 보관한다.
 */
public class ContextLoaderListener implements ServletContextListener {
	DBConnectionPool dbConnectionPool;
	
	@Override
	public void contextDestroyed(ServletContextEvent event) {
		System.out.println("contextDestroyed....");
		dbConnectionPool.closeAll();

	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		System.out.println("contextInitialized....");
		ServletContext sc = event.getServletContext();
		dbConnectionPool = new DBConnectionPool();
		dbConnectionPool.setDriver(sc.getInitParameter("driver"));
		dbConnectionPool.setUrl(sc.getInitParameter("url"));
		dbConnectionPool.setUsername(sc.getInitParameter("username"));
		dbConnectionPool.setPassword(sc.getInitParameter("password"));
		
		MysqlSubjectDao subjectDao = new MysqlSubjectDao();
		subjectDao.setDBConnectionPool(dbConnectionPool);
		sc.setAttribute("subjectDao", subjectDao);
		
		MysqlUserDao userDao = new MysqlUserDao();
		userDao.setDBConnectionPool(dbConnectionPool);
		sc.setAttribute("userDao", userDao);
		
		SubjectListControl subjectListControl = new SubjectListControl();
		subjectListControl.setSubjectDao(subjectDao);
		sc.setAttribute("/subject/list.bit", subjectListControl);
		
		SubjectDetailControl subjectDetailControl = 
				new SubjectDetailControl();
		subjectDetailControl.setSubjectDao(subjectDao);
		sc.setAttribute("/subject/detail.bit", subjectDetailControl);
		
	}

}
























