package basic.exam04.step06;

/* Collection 클래스 사용하기
 * - 배열보다 쉽게 인스턴스 목록을 관리
 * - ArrayList 사용!
 * 
 */
import java.util.ArrayList;
import java.util.Scanner;

public class StudentMgtSystem01 {
	private static Scanner scanner = new Scanner(System.in);
	
	private static ArrayList scoreList = new ArrayList();
	
	private static String[] promptCommand() {
		System.out.print("명령>");
		String input = scanner.nextLine(); 
		
		return input.split(" ");
	}
	
	private static void executeAdd(final String value) {
		String input;
		
		StudentScore score = StudentScore.fromCSV(value);
		
		System.out.println("이름:" + score.name);
		System.out.println("국어:" + score.kor);
		System.out.println("영어:" + score.eng);
		System.out.println("수학:" + score.math);
		
		System.out.print("등록하시겠습니까?(y/n)");
		input = scanner.nextLine();
		if ("y".equals(input.toLowerCase())) {
			scoreList.add(score);
			System.out.println("등록되었습니다.");
		} else {
			System.out.println("등록 취소하였습니다.");
		}
	}
	
	public static void executeList() {
		// ArrayList로부터 꺼낸다.
		for (int i = 0; i < scoreList.size(); i++) {
			System.out.println(scoreList.get(i));
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













