package listeners;

import java.io.File;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.naming.InitialContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.sql.DataSource;

import org.apache.log4j.Logger;

import annotations.Component;

/* 빈 자동 생성 - 애노테이션 이용하기 
 * 1) WEB-INF/classes 폴더에 있는 클래스들 중에서
 *    @Component 애노테이션이 붙은 클래스를 찾는다.
 *  2) 그 클래스의 인스턴스를 생성하여 objPool에 담는다.
 *  3) 나머지는 이전과 같다.
 * 
 */
public class ContextLoaderListener implements ServletContextListener {
	Logger log = Logger.getLogger(ContextLoaderListener.class);
	
	// 여러 인스턴스 메서드에서 objPool을 사용한다면,
	// 차라리 인스턴스 변수로 만든다.
	HashMap<String,Object> objPool = new HashMap<String,Object>();
	
	ServletContext sc;
	
	@Override
	public void contextDestroyed(ServletContextEvent event) {
		log.info("contextDestroyed....");
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		log.info("contextInitialized() 호출");
		sc = event.getServletContext();

		try {
			// DataSource 가져오기
			InitialContext ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup(
					"java:/comp/env/jdbc/studydb");
			
			// 임시 저장소에 객체 보관
			objPool.put("dataSource", ds);
			objPool.put("servletContext", sc);
		
			// @Component 애노테이션이 붙은 클래스를 찾아서 빈을 생성한다.
			prepareBeansFromAnnotation();
			
			// objPool에 들어 있는 빈에 대해 의존 객체를 찾아 주입한다.
			injectDependencies();
			
			// 임시 보관소에 저장된 객체들을 ServletContext에 복사한다.
			// DispatcherServlet이 페이지 컨트롤러를 찾을 수 있도록 하기 위해.
			for (Entry<String,Object> entry : objPool.entrySet()) {
				sc.setAttribute(entry.getKey(), entry.getValue());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private void injectDependencies() 
			throws Exception {
		// objPool에서 빈을 꺼내어 setXXX() 메서드를 찾는다.
		Class<?> clazz = null;
		Object dependency = null;
		for (Object obj : objPool.values()) {
			clazz = obj.getClass(); // 객체의 클래스 정보를 가져온다.
			log.debug(clazz.getName());
			
			// 셋터 메서드를 찾는다.
			for (Method m : clazz.getMethods()) {
				if (m.getName().startsWith("set")) {
					log.debug("==>" + m.getName());
					// 셋터 메서드의 파라미터 타입을 알아낸다.-> 의존 객체 찾는다.
					dependency = findDependency(m.getParameterTypes()[0]);
					if (dependency != null) { // 의존 객체를 찾았다면,
						// 셋터 메서드 호출 => 의존 객체 주입
						m.invoke(obj, dependency);	
						log.debug("  :" + m.getName() + " 호출 성공!");
					}
				}
			}
		}
  }
	
	private Object findDependency(Class<?> clazz) 
			throws Exception {
		for (Object dependency : objPool.values()) {
			if (clazz.isInstance(dependency)) {
				return dependency;
			}
		}
		return null;
	}

	private void prepareBeansFromAnnotation() throws Exception {
		// 클래스들이 있는 절대 경로 알아내기
		String path = sc.getRealPath("/WEB-INF/classes");
		File dir = new File(path);
		
		// 지정된 폴더에서 .class 파일을 찾는다.
		// @Component가 붙어 있는지 확인한다.
		// 해당 애노테이션이 붙어 있으면 빈을 생성하여 objPool에 담는다.
	  findAndCreateComponent(dir, "");
  }

	private void findAndCreateComponent(File dir, String packageName) 
			throws Exception {
	  File[] files = dir.listFiles(); // 하위 폴더 및 파일 목록 리턴
	  int index = 0;
	  String classname = null; // 패키지 이름을 포함한 클래스 이름
	  Class<?> clazz = null;
	  String compname = null; // objPool에 객체를 저장할 때 사용할 이름.
	  for (File f : files) {
	  	if (f.isDirectory()) {
	  		findAndCreateComponent(f, packageName + f.getName() + ".");
	  	} else { // only file
	  		if (f.getName().endsWith(".class")) { // only .class file
	  			// .class가 시작되는 인덱스 알아내기
	  			index = f.getName().indexOf(".class");
	  			classname = packageName + f.getName().substring(0, index);
	  			log.debug(classname);
	  			
	  			// 1) 클래스 로딩
	  			clazz = Class.forName(classname);
	  			
	  			// 2) @Component 애노테이션이 있는지 조사
        Component compAnno = 
	  					(Component) clazz.getAnnotation(Component.class);
	  			if (compAnno != null) {
	  				log.debug("**********" + classname);
	  				compname = compAnno.value(); // @Component(이름)
	  				if (compname.equals("")) { // @Component <- 이름이 없다면 
	  					compname = classname; // 클래스 이름을 객체 이름을 사용함
	  				}
	  				// 빈을 생성하여 임시 저장소에 보관한다.
	  				objPool.put(compname, clazz.newInstance());
	  				log.info("created:" + compname + "[" + classname + "]");
	  			}
	  		}
	  	}
	  }
	  
  }
}
























