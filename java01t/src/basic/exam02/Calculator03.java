package basic.exam02;

/* 인스턴스 멤버 변수
 * - 데이터를 개별적으로 관리할 필요가 있을 때 인스턴스 변수를 사용한다.
 * - 인스턴스 마다 개별적으로 만들어지는 변수
 * - static이 붙지 않는다.
 * - new 연산자를 사용하여 인스턴스 변수를 생성한다.
 */
public class Calculator03 {
	public int result; // 인스턴스를 만들 때 준비해야 할  변수
	
	public static void init(Calculator03 that, int v) {
		that.result = v;
	}
	
	public static void plus(Calculator03 that, int v) {
		that.result += v;
	}
	
	public static void minus(Calculator03 that, int v) {
		that.result -= v;
	}
	
	public static void multiple(Calculator03 that, int v) {
		that.result *= v;
	}
	
	public static void divide(Calculator03 that, int v) {
		that.result /= v;
	}
}














