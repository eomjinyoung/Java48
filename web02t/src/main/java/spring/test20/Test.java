package spring.test20;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext beanContainer = 
				new ClassPathXmlApplicationContext("spring/test20/beans.xml");
		
		Tire t1 = (Tire) beanContainer.getBean("tire1");
		System.out.println(t1);
		
	}
}

















