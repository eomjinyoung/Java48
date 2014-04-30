package spring.test15;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext beanContainer = 
				new ClassPathXmlApplicationContext("spring/test15/beans.xml");
		
		Engine e1 = (Engine) beanContainer.getBean("engine1");
		Car c1 = (Car) beanContainer.getBean("car1");
		
		if (c1.getEngine() != null) {
			System.out.println("엔진이 있다.");
		} else {
			System.out.println("엔진이 없다!");
		}
		
	}
}

















