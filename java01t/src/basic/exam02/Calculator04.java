package basic.exam02;

/* 인스턴스 메서드와 this
 * - 인스턴스 메서드: 인스턴스를 사용하여 작업을 수행하는 메서드.
 * - static을 붙이지 않는다.
 * - 인스턴스 주소를 갖고 있는 this라는 감춰져 있는 변수가 있다.
 * - 코딩이 간결해진다.
 */
public class Calculator04 {
	public int result; // 인스턴스를 만들 때 준비해야 할  변수
	
	// 인스턴스 주소를 받기 위해 파라미터를 별도로 선언할 필요가 없다.
	// 메서드가 호출될 때 자동으로 this 변수에 인스턴스 주소가 저장된다.
	public void init(/*Calculator04 this,*/ int v) {
		this.result = v;
	}
	
	public void plus(/*Calculator04 this,*/ int v) {
		this.result += v;
	}
	
	public void minus(/*Calculator04 this,*/ int v) {
		this.result -= v;
	}
	
	public void multiple(/*Calculator04 this,*/ int v) {
		this.result *= v;
	}
	
	public void divide(/*Calculator04 this,*/ int v) {
		this.result /= v;
	}
}














