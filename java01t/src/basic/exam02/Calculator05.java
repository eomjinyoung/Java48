package basic.exam02;

/* 생성자
 * - 인스턴스 생성 직후 자동으로 호출되는 메서드
 * - 인스턴스 변수를 초기화
 */
public class Calculator05 {
	public int result; 
	
	/* 생성자 선언
	 * - 클래스 이름과 같은 이름을 갖는다.
	 * - 파라미터가 없는 생성자를 '기본 생성자(default constructor)'라 말한다.
	 * - 생성자가 없으면 컴파일할 때 컴파일러가 자동으로 추가한다.
	 * - 인스턴스를 생성할 때 반드시 생성자가 호출된다.
	 * - 중요! 생성자의 존재 의의?
	 *   인스턴스가 제대로 자신의 역할 수행할 수 있도록 최소한의 준비를 시키는 것.
	 *   => 유효한 초기값 할당.
	 */
	public Calculator05() {} // 아래에 생성자가 있기 때문에 기본 생성자를 자동으로 추가되지 않는다.
	
	/* 파라미터 값을 받는 생성자 선언
	 * - 인스턴스를 생성할 때 초기화시킬 값을 생성자를 통해 받는다.
	 * - 이 생성자를 호출하기 위해서는 받드시 지정된 파라미터 값을 줘야 한다.
	 */
	public Calculator05(int v) {
		this.result = v;
	}
	
	public void init(int v) {
		this.result = v;
	}
	
	public void plus(int v) {
		this.result += v;
	}
	
	public void minus(int v) {
		this.result -= v;
	}
	
	public void multiple(int v) {
		this.result *= v;
	}
	
	public void divide(int v) {
		this.result /= v;
	}
}














