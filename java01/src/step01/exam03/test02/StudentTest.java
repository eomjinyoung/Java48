package step01.exam03.test02;

public class StudentTest {
	public static void main(String[] args) {
		// Student2에서 재정의한 equals() 사용하기
		Student2 s1 = new Student2("홍길동", 90, 100, 90);
		Student2 s2 = new Student2("홍길동", 90, 100, 90);

		if (s1 == s2) System.out.println("s1 == s2");
		if (s1.equals(s2)) System.out.println("s1.equals(s2)");
	}
	
	public static void main01(String[] args) {
		// Object로부터 상속받은 equals()는 == 연산자와 동일하게 동작한다. 인스턴스가 같은지 비교한다.
		Student s1 = new Student("홍길동", 90, 100, 90);
		Student s2 = new Student("홍길동", 90, 100, 90);

		if (s1 == s2) System.out.println("s1 == s2");
		if (s1.equals(s2)) System.out.println("s1.equals(s2)");
	}

}
