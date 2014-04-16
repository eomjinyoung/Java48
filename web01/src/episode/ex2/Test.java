package episode.ex2;

/* Aspect-Oriented Programming 방식으로 기능 확장
 * - 프록시 개념을 적용
 * - 프록시: 원래 객체를 대행하는 역할  
 */
public class Test {

	public static void main(String[] args) {
		MyClass obj = new MyFilter();
		obj.m();

	}

}
