package basic.exam02;

/* 계산 결과를 개별적으로 관리하고 싶다!
 * 데이터를 개별적으로 관리
 * - 클래스 멤버 변수로는 불가능!
 * - 새로운 문법이 필요! => 인스턴스 변수(객체 변수)
 * 
 */
public class Test03 {

	public static void main(String[] args) {
		//10 + 30 - 4 * 7 = 252 (연산자 우선순위 고려하지 않음)
		//5 * 3 - 6 / 3 = 3 (연산자 우선순위 고려하지 않음)
		
		// 인스턴스 생성
		// - Calculator03에 선언된 변수를 참고하여 인스턴스를 생성하라!
		Calculator03 calc1 = new Calculator03();
		Calculator03 calc2 = new Calculator03();
		
		Calculator03.init(calc1, 10);
		Calculator03.init(calc2, 5);
		
		Calculator03.plus(calc1, 30);
		Calculator03.multiple(calc2, 3);
		
		Calculator03.minus(calc1, 4);
		Calculator03.minus(calc2, 6);
		
		Calculator03.multiple(calc1, 7);
		Calculator03.divide(calc2, 3);
		
		System.out.println(calc1.result);
		System.out.println(calc2.result);
	}

}








