package spring.test11;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext beanContainer = 
				new ClassPathXmlApplicationContext("spring/test11/beans.xml");
		
		Tire t1 = (Tire) beanContainer.getBean("tire1");
		System.out.println(t1);
		
		Tire t2 = (Tire) beanContainer.getBean("tire2");
		System.out.println(t2);
		
	}
}

















