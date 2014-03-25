package basic.exam04.step02;

/* 데이터를 표현하는 클래스 : Value Object = Data Transfer Object
 * - 복합 데이터의 새로운 유형을 정의한다.
 *   => 새로운 형식의 데이터 타입을 정의.
 * - 데이터 타입 예) 
 *  => byte, short, int, long, float, double, boolean, char
 * 
 */
public class StudentScore {
	// 인스턴스 변수: 값을 개별로 다뤄야 한다면 인스턴스 변수 선언.
	String name;
	int kor;
	int eng;
	int math;
	
	// 생성자: 객체가 사용되기 전에 최소한의 준비 작업(초기화 시키는 작업)
	// - name 항목을 필수 값으로 간주한다.
	//    => name 값 없이 인스턴스를 생성할 수 없다.
	public StudentScore(String name) {
		this.name = name;
	}
}



















