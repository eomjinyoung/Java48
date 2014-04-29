package spring.test07;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext beanContainer = 
				new ClassPathXmlApplicationContext("spring/test07/beans.xml");
		
		Car c1 = (Car) beanContainer.getBean("car1");
		
		System.out.println(c1);
	}
}

















