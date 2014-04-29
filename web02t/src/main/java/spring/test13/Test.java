package spring.test13;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext beanContainer = 
				new ClassPathXmlApplicationContext("spring/test13/beans.xml");
		
		Tire t1 = (Tire) beanContainer.getBean("tire1");
		Engine e1 = (Engine) beanContainer.getBean("engine1");
		Car c1 = (Car) beanContainer.getBean("car1");
		
		System.out.println(t1);
		System.out.println(e1);
		System.out.println(c1);
		
	}
}

















