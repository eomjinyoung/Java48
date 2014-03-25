package basic.exam02;

public class Test02 {

	public static void main(String[] args) {
		//10 + 30 - 4 * 7 = 252 (연산자 우선순위 고려하지 않음)
		Calculator02.init(10);
		Calculator02.plus(30);
		Calculator02.minus(4);
		Calculator02.multiple(7);
		
		System.out.println(Calculator02.result);
	}

}
