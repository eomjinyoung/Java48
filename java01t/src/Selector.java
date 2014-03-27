import java.util.Scanner;


public class Selector {
	static int[] students;
	
	public static void main(String[] args) {
		Scanner scanner  = new Scanner(System.in);
		System.out.print("인원은?");
		int count = Integer.parseInt( scanner.nextLine());
		System.out.print("팀원수?");
		int teamSize = Integer.parseInt( scanner.nextLine());

		students = new int[count];

		for (int i : students) 
			students[i] = 0;

		int selectedCount = 0;
		int teamCount = 1;

		loop:
		while (true) {
			System.out.print(teamCount + "팀:");
			for(int i = 0; i < teamSize; i++) {
				System.out.print(selectedStudentNo() + ",");
				selectedCount++;
				if (selectedCount >= count)
					break loop; 
			}
			System.out.println();
			scanner.nextLine();
			teamCount++;
		}

		System.out.println("끝!");
	}

	private static  int selectedStudentNo() {
		int selectedNo = 0;
		while(true) {
			selectedNo = (int)(Math.random() * students.length); // 0 <= x < 1
			if (students[selectedNo] == 0) {
				students[selectedNo] = 1;
				return selectedNo + 1;
			}
		}
	}


}
