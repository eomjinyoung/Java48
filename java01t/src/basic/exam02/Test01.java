package basic.exam02;

public class Test01 {

	public static void main(String[] args) {
		//10 + 30 - 4 * 7 = 252 (연산자 우선순위 고려하지 않음)
		int result = 0;
		
		result = Calculator01.plus(10, 30);
		result = Calculator01.minus(result, 4);
		result = Calculator01.multiple(result, 7);
		
		System.out.println(result);
	}

}
