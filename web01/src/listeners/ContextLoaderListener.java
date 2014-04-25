package listeners;

import java.io.FileReader;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import util.DBConnectionPool;

/* PageController를 ServletContext에 보관함.
 * - PageController가 필요로 하는 의존 객체를 주입한 후에 보관한다.
 */
public class ContextLoaderListener implements ServletContextListener {
	ServletContext sc;
	DBConnectionPool dbConnectionPool;
	
	@Override
	public void contextDestroyed(ServletContextEvent event) {
		System.out.println("contextDestroyed....");
		dbConnectionPool.closeAll();

	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		System.out.println("contextInitialized....");
		sc = event.getServletContext();
		dbConnectionPool = new DBConnectionPool();
		dbConnectionPool.setDriver(sc.getInitParameter("driver"));
		dbConnectionPool.setUrl(sc.getInitParameter("url"));
		dbConnectionPool.setUsername(sc.getInitParameter("username"));
		dbConnectionPool.setPassword(sc.getInitParameter("password"));
		
		// 생성된 객체를 보관할 임시 저장소
		HashMap<String,Object> objPool = new HashMap<String,Object>();
		objPool.put("dbConnectionPool", dbConnectionPool);
		
		try {
			// .properties 파일을 읽어서 빈을 생성한다.
			prepareBeansFromProperties(objPool);
			
			// objPool에 들어 있는 빈에 대해 의존 객체를 찾아 주입한다.
			injectDependencies(objPool);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void injectDependencies(HashMap<String, Object> objPool) {
		// objPool에서 빈을 꺼내어 setXXX() 메서드를 찾는다.
		Class<?> clazz = null;
		for (Object obj : objPool.values()) {
			clazz = obj.getClass(); // 객체의 클래스 정보를 가져온다.
			System.out.println(clazz.getName());
			
			// 셋터 메서드를 찾는다.
			for (Method m : clazz.getMethods()) {
				if (m.getName().startsWith("set")) {
					System.out.println("==>" + m.getName());
				}
			}
		}
	  
  }

	private void prepareBeansFromProperties(
			HashMap<String, Object> objPool) throws Exception {
		// properties 파일이 있는 경로 알아내기
		String path = sc.getRealPath("/WEB-INF/classes/beans.properties");
		FileReader propIn = new FileReader(path); // 읽기 준비
		
		// beans.properties 파일 읽기
	  Properties props = new Properties();
	  props.load(propIn);
	  
	  // 프로퍼티 파일에 적혀있는대로 빈을 생성한다.
	  Class<?> clazz = null;
	  for (Entry<Object,Object> entry : props.entrySet()) {
	  	clazz = Class.forName( (String)entry.getValue() );
	  	objPool.put( (String)entry.getKey(), clazz.newInstance());
	  }
  }
}
























