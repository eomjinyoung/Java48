package basic.exam01;

/* 변수와 블록
 * - 변수는 블록 내에서만 사용가능.
 * - 내부 블록은 바깥 블록의 변수 접근 가능.
 * - 블록이 끝나면 블록 안에 선언된 변수는 삭제된다.
 * - 변수가 선언된 블록에 종속됨.
 */
public class Test05 {

	public static void main(String[] args) {
		int a = 20;
		{
			//int a = 30; // 오류! 바깥 쪽에 같은 이름의 변수가 있다.
			int b = 30;
			{
				int c = 40;
				System.out.println(a);
				System.out.println(b);
				System.out.println(c);
			}
			System.out.println(a);
			System.out.println(b);
			//System.out.println(c); // 블록을 벗어나면 변수는 제거된다.
		}
		System.out.println(a);
		//System.out.println(b); // 블록을 벗어났다.
	}

}









