package spring.test04;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext beanContainer = 
				new ClassPathXmlApplicationContext("spring/test04/beans.xml");
		
		Score s1 = (Score)beanContainer.getBean("s1");
		printScore(s1);
		
		Score s2 = (Score)beanContainer.getBean("s2");
		printScore(s2);
		
	}
	
	public static void printScore(Score s) {
		System.out.format(
				"%1$3s: %2$3d, %3$3d, %4$3d, %5$3d, %6$3.1f\n", 
				s.getName(), s.getKor(), s.getEng(), s.getMath(),
				s.sum(), s.average());
	}
}

















