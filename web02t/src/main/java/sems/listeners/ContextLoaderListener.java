package sems.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* 스프링 IoC 컨테이너 적용
 */
public class ContextLoaderListener implements ServletContextListener {
	Logger log = Logger.getLogger(ContextLoaderListener.class);
	
	// Spring IoC 컨테이너 참조 변수
	// - 공개한 이유: DispatcherServlet이 사용하기 때문에
	public static ClassPathXmlApplicationContext applicationContext;
	
	
	@Override
	public void contextDestroyed(ServletContextEvent event) {
		log.info("contextDestroyed....");
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		log.info("contextInitialized() 호출");
		applicationContext = 
				new ClassPathXmlApplicationContext("beans.xml");
	}
}
























