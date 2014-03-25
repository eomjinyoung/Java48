package basic.exam01;

//1. 주석
// - 컴파일러가 무시하는 문장
// 1) 라인 주석: 라인 끝까지 주석으로 처리
// 2) 멀티라인 주석: /*에서  */를 만날 때 까지 주석
// 3) javadoc 주석: /**에서 */를 만날 때 까지 주석. Java API 문서를 만들 때 사용하는 주석.

//참고) 애노테이션: @지시어(이름=값, 이름=값, ...) 컴파일러와 JVM에 전달하는 특별한 주석

/* 이 예제는 주석을 보여주기 위한 예제이다.
 * 중간에 '*' 표시는 그냥 모양을 만들기 위한 것이다.
 */
/**
 * 이 클래스는 주석에 대한 설명과 javadoc 주석을 만들기 위한 방법을 보여주고 있습니다.
 * javadoc 주석은 javadoc.exe 명령어로 추출하여 API 문서를 만들 때 사용한다.
 * API 문서는 .html 파일이다.
 * javadoc 주석에서 사용하는 특별한 명령어가 있다. '@'로 시작한다.
 * javadoc 주석은 클래스 선언 앞, 변수 선언 앞, 메서드(함수)선언 앞에 붙인다.
 * 
 * @author Java48 at BitAcademy
 * 
 */
public class Test01 {

	/**
	 * 정수 값 두 개 받아서 더한 결과를 반환하는 함수
	 * @param a (정수값)
	 * @param b (정수값)
	 * @return a와 b를 더한 결과 값 
	 */
	public static int plus(int a, int b) {
		return a + b;
	}
	
	public static void main(String[] args) {
		System.out.println("a + b = " + plus(10, 20));

	}

}







