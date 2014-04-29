package spring.test09;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext beanContainer = 
				new ClassPathXmlApplicationContext("spring/test09/beans.xml");
		
		Tire t1 = (Tire) beanContainer.getBean("tire1");
		System.out.println(t1);
		
		Tire t2 = (Tire) beanContainer.getBean("tire2");
		System.out.println(t2);
		
		Tire t3 = (Tire) beanContainer.getBean("tire3");
		System.out.println(t3);
		
		Tire t4 = (Tire) beanContainer.getBean("tire4");
		System.out.println(t4);
		
		Tire t5 = (Tire) beanContainer.getBean("tire5");
		System.out.println(t5);
		
	}
}

















