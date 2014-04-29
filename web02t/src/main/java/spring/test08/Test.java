package spring.test08;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext beanContainer = 
				new ClassPathXmlApplicationContext("spring/test08/beans.xml");
		
		Tire t1 = (Tire) beanContainer.getBean("tire1");
		System.out.println(t1);
		
		System.out.println("--------------------------------");
		Car c1 = (Car) beanContainer.getBean("car1");
		System.out.println(c1);
		
	}
}

















