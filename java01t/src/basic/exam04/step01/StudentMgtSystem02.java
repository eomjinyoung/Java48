package basic.exam04.step01;

/* 메서드로 명령어를 묶음
 * - 명령어들을 재사용하기가 쉽다.
 * 
 */
import java.util.Scanner;

public class StudentMgtSystem02 {
	private static Scanner scanner = new Scanner(System.in);
	
	private static String[] promptCommand() {
		System.out.print("명령>");
		String input = scanner.nextLine(); 
		
		return input.split(" ");
	}
	
	public static void main(String[] args) {
		String input = null; // 로컬 변수는 항상 null로 초기화 한다.
		do {
			String[] values = promptCommand();
			
			if ("add".equals(values[0])) {
				String[] data = values[1].split(",");
				System.out.println("이름:" + data[0]);
				System.out.println("국어:" + data[1]);
				System.out.println("영어:" + data[2]);
				System.out.println("수학:" + data[3]);
				
				System.out.print("등록하시겠습니까?(y/n)");
				input = scanner.nextLine();
				if ("y".equals(input.toLowerCase())) {
					System.out.println("등록되었습니다.");
				} else {
					System.out.println("등록 취소하였습니다.");
				}
			} else if ("quit".equals(values[0])) {
				break;
			} else {
				System.out.println("사용할 수 없는 명령어입니다.");
			}
			
		} while(true);

		scanner.close();
	}

}













