package basic.exam05.step03;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class StudentControl {
	static Scanner scanner;
	private static ArrayList<Student> studentList 
												= new ArrayList<Student>();
	
	static {
		scanner = StudentMgtSystem.scanner;
	}
	
	private static void executeAdd(final String value) {
		String input;
		
		Student student = Student.fromCSV(value);
		
		System.out.println("이름:" + student.name);
		System.out.println("나이:" + student.age);
		System.out.println("전화:" + student.tel);
		System.out.println("이메일:" + student.email);
		System.out.println("주소:" + student.address);
		
		System.out.print("등록하시겠습니까?(y/n)");
		input = scanner.nextLine();
		if ("y".equals(input.toLowerCase())) {
			studentList.add(student);
			System.out.println("등록되었습니다.");
		} else {
			System.out.println("등록 취소하였습니다.");
		}
	}
	
	private static void executeList() {
		int i = 0;
		for (Student student : studentList) {
			System.out.println(i++ + " " + student);
		}
	}
	
	private static void executeDelete(final int no) {
	  if (no >= 0 && no < studentList.size()) {
	  	studentList.remove(no);
	  	System.out.println("삭제하였습니다.");
	  } else {
	  	System.out.println("유효하지 않은 번호입니다.");
	  }
  }
	
	private static void executeUpdate(final int no) {
		if (no >= 0 && no < studentList.size()) {
			Student temp = new Student();
			
			Student student = studentList.get(no);
			System.out.print("이름(" + student.name + "):");
			temp.name = scanner.nextLine();
			
			System.out.print("나이(" + student.age + "):");
			temp.age = Integer.parseInt(scanner.nextLine());
			
			System.out.print("전화(" + student.tel + "):");
			temp.tel = scanner.nextLine();
			
			System.out.print("이메일(" + student.email + "):");
			temp.email = scanner.nextLine();
			
			System.out.print("주소(" + student.address + "):");
			temp.address = scanner.nextLine();
			
			System.out.print("변경하시겠습니까?(y/n)");
			String input = scanner.nextLine();
			if ("y".equals(input.toLowerCase())) {
				studentList.set(no, temp);
				System.out.println("변경되었습니다.");
			} else {
				System.out.println("변경 취소하였습니다.");
			}
		} else {
			System.out.println("유효하지 않은 번호입니다.");
		}
  }
	
	private static void executeSave() {
		try {
			FileWriter out = new FileWriter("student.data");
			for(Student student : studentList) {
				out.write(student.toString() + "\n");
			}
			out.close();
			System.out.println("저장되었습니다.");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static void executeLoad() {
		try {
			FileReader in = new FileReader("student.data");
			Scanner s = new Scanner(in);
			while(true) {
				try {
					studentList.add(Student.fromCSV(s.nextLine()));
				} catch (NoSuchElementException ex) {
					break;
				}
			}
			s.close();
			in.close();
			System.out.println("로딩되었습니다.");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static void execute() {
		do {
			String[] values = promptCommand();
			
			if ("add".equals(values[0])) {
				executeAdd(values[1]);
			} else if ("list".equals(values[0])) {
				executeList();
			} else if ("delete".equals(values[0])) {
				executeDelete(Integer.parseInt(values[1]));
			} else if ("update".equals(values[0])) {
				executeUpdate(Integer.parseInt(values[1]));
			} else if ("save".equals(values[0])) {
				executeSave();
			} else if ("load".equals(values[0])) {
				executeLoad();
			} else if ("menu".equals(values[0])) {
				break;
			} else {
				System.out.println("사용할 수 없는 명령어입니다.");
			}
		} while(true);
	}
	
	private static String[] promptCommand() {
		System.out.print("학생관리>");
		String input = scanner.nextLine(); 
		
		return input.split(" ");
	}
}














