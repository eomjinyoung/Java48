package spring.test01;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	//익명 빈 꺼내기
	public static void main(String[] args) {
		ClassPathXmlApplicationContext beanContainer = 
				new ClassPathXmlApplicationContext("spring/test01/beans.xml");
		
		Score a1 = (Score)beanContainer.getBean("spring.test01.Score");
		Score a2 = (Score)beanContainer.getBean("spring.test01.Score#0");
		Score a3 = (Score)beanContainer.getBean("spring.test01.Score#1");
		
		if (a1 != null) {
			System.out.println("a1 존재함.");
		}
		
		if (a1 == a2) {
			System.out.println("a1 == a2");
		}
		
		if (a2 != a3) {
			System.out.println("a2 != a3");
		}
	}
	
	//빈의 이름과 별명
	public static void main04(String[] args) {
		ClassPathXmlApplicationContext beanContainer = 
				new ClassPathXmlApplicationContext("spring/test01/beans.xml");
		
		Score s1 = (Score)beanContainer.getBean("s1");
		Score s2 = (Score)beanContainer.getBean("s2");
		Score s5 = (Score)beanContainer.getBean("score-ok!");
		
		System.out.println("빈 컨테이너에 등록된 빈들의 이름을 알아내기");
		for (String name : beanContainer.getBeanDefinitionNames()) {
			System.out.println(name);
		}
		
		System.out.println("빈 컨테이너에 등록된 특정 빈의 별명 알아내기");
		for (String alias : beanContainer.getAliases("s2")) {
			System.out.println(alias);
		}
	}
	
	// id와 name
	public static void main03(String[] args) {
		ClassPathXmlApplicationContext beanContainer = 
				new ClassPathXmlApplicationContext("spring/test01/beans.xml");
		
		Score s1 = (Score)beanContainer.getBean("s1");
		Score s2 = (Score)beanContainer.getBean("s2");
		Score s3 = (Score)beanContainer.getBean("s3");
		Score s4 = (Score)beanContainer.getBean("s4");
		Score s5 = (Score)beanContainer.getBean("score-ok!");
		
		if (s1 != s2) {
			System.out.println("s1 != s2");
		}
		if (s2 == s3) {
			System.out.println("s2 == s3");
		}
		if (s3 == s4) {
			System.out.println("s3 == s4");
		}
		if (s5 != null) {
			System.out.println("s5 != null");
		}
	}
	
	// ClassPathXmlApplicationContext
	// - 빈 컨테이너 => 설정 내용에 따라 빈을 생성하여 보관.
	// - getBean() => 빈 컨테이너에서 준비된 인스턴스를 꺼낸다.
	public static void main02(String[] args) {
		ClassPathXmlApplicationContext beanContainer = 
				new ClassPathXmlApplicationContext("spring/test01/beans.xml");
		
		Score s1 = (Score)beanContainer.getBean("s1");
		
		if (s1 != null) {
			System.out.println("객체 생성되었음.");
		}
	}
	
	public static void main01(String[] args) {
		Score s1 = new Score();
		s1.setName("임꺽정");
		s1.setKor(100);
		s1.setEng(87);
		s1.setMath(65);
		
		Score s2 = new Score("홍길동", 99, 88, 77);
		
		printScore(s1);
		printScore(s2);
	}
	
	public static void printScore(Score s) {
		System.out.format(
				"%1$3s: %2$3d, %3$3d, %4$3d, %5$3d, %6$3.1f\n", 
				s.getName(), s.getKor(), s.getEng(), s.getMath(),
				s.sum(), s.average());
	}

}


















