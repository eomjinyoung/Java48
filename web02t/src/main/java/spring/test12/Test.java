package spring.test12;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext beanContainer = 
				new ClassPathXmlApplicationContext("spring/test12/beans.xml");
		
		Tire t1 = (Tire) beanContainer.getBean("tire1");
		Tire t2 = (Tire) beanContainer.getBean("tire1");
		System.out.println(t1);
		
		if (t1 == t2) {
			System.out.println("t1 == t2");
		}
		
		System.out.println("-----------------------------------");
		Tire t3 = (Tire) beanContainer.getBean("tire2");
		Tire t4 = (Tire) beanContainer.getBean("tire2");
		System.out.println(t1);
		
		if (t3 != t4) {
			System.out.println("t3 != t4");
		}
	}
}

















