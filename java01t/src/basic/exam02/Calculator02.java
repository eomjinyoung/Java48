package basic.exam02;

/* 클래스 멤버 변수
 * - static 으로 선언된 변수
 * - 클래스가 준비될 때 자동으로 만들어진다.
 * - static 데이터유형 변수명;
 */
public class Calculator02 {
	public static int result;
	
	public static void init(int v) {
		result = v;
	}
	
	public static void plus(int v) {
		result += v;
	}
	
	public static void minus(int v) {
		result -= v;
	}
	
	public static void multiple(int v) {
		result *= v;
	}
	
	public static void divide(int v) {
		result /= v;
	}
}














