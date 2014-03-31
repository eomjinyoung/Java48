package basic.exam05.step06;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class StudentControl {
	static Scanner scanner;
	public ArrayList<Student> studentList 
												= new ArrayList<Student>();
	
	public void add(final Student student) {
		studentList.add(student);
	}
	
	private void executeList() {
		int i = 0;
		for (Student student : studentList) {
			System.out.println(i++ + " " + student);
		}
	}
	
	private void executeDelete(final int no) {
	  if (no >= 0 && no < studentList.size()) {
	  	studentList.remove(no);
	  	System.out.println("삭제하였습니다.");
	  } else {
	  	System.out.println("유효하지 않은 번호입니다.");
	  }
  }
	
	private void executeUpdate(final int no) {
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
	
	private void executeSave() {
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
	
	public void executeLoad() {
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
}














