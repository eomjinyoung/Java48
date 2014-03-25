package basic.exam01;

/* 3. 데이터 형 변환
 * - 데이터의 유형을 자동 또는 수동으로 변환하여 새 메모리에 보관
 * - 기존 변수의 유형이 바뀌는 것은 아니다!
 * 1) 암시적 형변환(implicit type conversion)
 * - 연산을 수행하기 위해 JVM이 임의로 메모리를 생성하여 값을 변환하여 저장하는 행위
 * - (byte,short,char) -> int -> long -> float -> double
 * 
 * 2) 명시적 형변환(explicit type conversion)
 * - 개발자가 명령어를 사용하여 임시로 메모리를 생성하여 변환된 값을 저장하는 것
 */
public class Test03 {

	public static void main(String[] args) {
		// 명시적 형변환
		byte b1 = 2;
		short s1 = 3;
		int r1 = (int)b1 + (int)s1; 
		
		int i1 = 20;
		long l1 = 30;
		long r2 = (long)b1 + (long)i1 + l1; 
		
		// 명시적 형변환 응용
		int i = 5;
		int j = 2;
		float f = i / j; // int + int = int. 할당하기 전에 결과가 이미 int이다.
		System.out.println(f);
		
		float f2 = (float)i / (float)j;
		System.out.println(f2);
		
		float f3 = i / (float)j; // i -> float(암시적 형변환)
		System.out.println(f3);
		
	}
	
	public static void main01(String[] args) {
		// 암시적 형변환
		byte b1 = 2;
		short s1 = 3;
		int r1 = b1 + s1; // b1->int, s1->int 
		
		int i1 = 20;
		long l1 = 30;
		long r2 = b1 + i1 + l1; // b1 -> int, (b1 + i1) -> long 

	}

}













