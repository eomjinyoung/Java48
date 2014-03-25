package basic.exam01;

/* 배열
 * - 같은 데이터형의 값을 여러개 저장하는 메모리
 * - 문법
 *   new 데이터형[갯수];
 */
public class Test04 {
	public static void main(String[] args) {
		int[] p = new int[3];
		p[0] = 90;
		p[1] = 90;
		p[2] = 100;
		//p[3] = 10; // 없는 인덱스 가리키면 오류!
		
		int[] p2 = p;
		p[2] = 55;
		System.out.println(p2[2]);
		
		//char[] p3 = p; // 용서받지 못할 코드 
		
		// 배열 선언과 동시에 초기화
		int[] scores = new int[]{90, 90, 100};
		System.out.println(scores.length);
		System.out.println(scores[1]);
		for (int i = 0; i < scores.length; i++) {
			System.out.println(">>" + scores[i]);
		}
		
	}
}


















