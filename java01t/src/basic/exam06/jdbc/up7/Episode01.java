package basic.exam06.jdbc.up7;

class Patient01 {
	String name;
	int age;
	int weight;
	int height;
	String bloodType;
}

public class Episode01 {
	public static void main(String[] args) {
		Patient01 p1 = new Patient01();
		p1.name = "홍길동";
		p1.age = -200; // 유효하지 않은 나이 
		p1.weight = -90; // 유효하지 않은 몸무게
		p1.height = 280;// 유효하지 않은 키 
		p1.bloodType = "X"; //유효하지 않은 혈액형
		
		/* 유효하지 않은 값이 허용되면 
		 * => 추상화를 한 의미가 없다.
		 * => 시스템 실행 시 치명적인 업무 오류를 유발한다.
		 * 
		 * 해결책 : 캡슐화(encapsulation)
		 * => 유효하지 않은 값을 가지는 것을 방지!
		 * => 잘못된 메서드 호출을 방지! 	
		 * => 문법: private, (default), protected, public
		 * private: 클래스 멤버(변수,메서드)만 가능
		 * (default): 클래스 멤버 + 패키지 멤버 가능
		 * protected: 클래스 멤버 + 패키지 멤버 + 자식 클래스
		 * public : 모두
		 */

	}

}

















