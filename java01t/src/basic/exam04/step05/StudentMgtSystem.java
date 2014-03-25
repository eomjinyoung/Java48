package basic.exam04.step05;

/* 클래스 변수 초기화 : static {} 블록
 * - 인스턴스 변수는 생성자를 통해 초기화할 수 있다.
 * - 클래스 변수는? 스택틱 블록을 통해 초기화 할 수 있다.
 * 
 * 상수 변수의 사용
 * - 상수 값이 소스 코드의 여러 곳에서 사용된다면 유지보수를 좋게 하기 위해
 *   클래스 변수로 정의해 두는 것이 좋다. => 변경이 쉬워진다. 
 * 
 */
import java.util.Scanner;

public class StudentMgtSystem {
	private static Scanner scanner = new Scanner(System.in);
	
	private static StudentScore[] scoreList;
	private static int scoreSize;
	
	// 상수 변수의 선언 => 인스턴스 별로 값이 다르지 않다 => 클래스 변수로 만든다.
	// => 참조용(rean only)이기 때문에 값을 바꿀 수 없도록 한다.
	// => final 로 선언: 값을 한 번만 할당 가능!
	// => 파라미터 변수에 대해서도 값을 바꾸지 못하도록 final 로 선언한다.
	private static final int SCORE_MAX_SIZE = 3;
	
	// static 블록은 클래스를 변수를 초기화 하는 용도로 사용한다.
	// 클래스로딩 => 클래스 변수 생성 및 초기화 문장 수행 => static 블록 수행 
	static {
		scoreList = new StudentScore[SCORE_MAX_SIZE];
	}
	
	
	private static String[] promptCommand() {
		System.out.print("명령>");
		String input = scanner.nextLine(); 
		
		return input.split(" ");
	}
	
	// 실무에서는 좀 더 코드의 잘못된 사용을 방지하기 위해
	// 파라미터 변수에 대해 final로 선언한다.
	private static void executeAdd(final String value) {
		String input;
		
		// 로컬 변수에 담는 대신 클래스 변수에 저장한다.
		//StudentScore score = StudentScore.fromCSV(value);
		if (scoreSize < SCORE_MAX_SIZE) {
			scoreList[scoreSize++] = StudentScore.fromCSV(value);
		} else {
			System.out.println("저장소가 꽉 찼습니다!");
			return; // 즉시 함수를 탈출
		}
		
		System.out.println("이름:" + scoreList[scoreSize - 1].name);
		System.out.println("국어:" + scoreList[scoreSize - 1].kor);
		System.out.println("영어:" + scoreList[scoreSize - 1].eng);
		System.out.println("수학:" + scoreList[scoreSize - 1].math);
		
		System.out.print("등록하시겠습니까?(y/n)");
		input = scanner.nextLine();
		if ("y".equals(input.toLowerCase())) {
			System.out.println("등록되었습니다.");
		} else {
			System.out.println("등록 취소하였습니다.");
		}
	}
	
	public static void executeList() {
		for (StudentScore score : scoreList) {
			System.out.println(score);
		}
	}
	
	public static void main(String[] args) {
		do {
			String[] values = promptCommand();
			
			if ("add".equals(values[0])) {
				executeAdd(values[1]);
			} else if ("list".equals(values[0])) {
				executeList();
			} else if ("quit".equals(values[0])) {
				break;
			} else {
				System.out.println("사용할 수 없는 명령어입니다.");
			}
			
		} while(true);

		scanner.close();
	}


}













