package spring.test05;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext beanContainer = 
				new ClassPathXmlApplicationContext("spring/test05/beans.xml");
		
		Engine e1 = (Engine) beanContainer.getBean("engine1");
		Car c1 = (Car) beanContainer.getBean("car1");
		Car c2 = (Car) beanContainer.getBean("car2");
		Car c3 = (Car) beanContainer.getBean("car3");
		Car c4 = (Car) beanContainer.getBean("car4");
		
		System.out.println(e1);
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
		System.out.println(c4);
		
		if (c1.getEngine() == c2.getEngine()) {
			System.out.println("c1.engine == c2.engine");
		}
		if (c2.getEngine() == c3.getEngine()) {
			System.out.println("c2.engine == c3.engine");
		}
		if (c3.getEngine() == c4.getEngine()) {
			System.out.println("c3.engine == c4.engine");
		}
		if (c4.getEngine() == e1) {
			System.out.println("c4.engine == e1");
		}
		
	}
}

















