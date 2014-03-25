package basic.exam03.test02;

// Object를 상속받는다고 명시하지 않으면 
// extends Object 가 자동으로 추가된다.
// 상속을 받는다는 것!
// - 상속받는 클래스의 메서드를 호출할 수 있다는 의미.
// - 상속해주는 클래스 => parent, super 클래스
// - 상속받는 클래스 => child, sub 클래스 
public class Student /*extends Object*/ {
	String 	name;
	int			kor;
	int			math;
	int			eng;
	
	public Student(String name, int kor, int math, int eng) {
		this.name = name;
		this.kor = kor;
		this.math = math;
		this.eng = eng;
	}
}
