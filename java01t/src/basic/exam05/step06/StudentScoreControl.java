package basic.exam05.step06;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class StudentScoreControl {
	static Scanner scanner;
	public ArrayList<StudentScore> scoreList 
												= new ArrayList<StudentScore>();
	
	public void add(final StudentScore score) {
		scoreList.add(score);
	}
	
	public void remove(final int no) {
		scoreList.remove(no);
  }
	
	public void update(final int no, final StudentScore score) {
		scoreList.set(no, score);
  }
	
	public void save() {
		try {
			FileWriter out = new FileWriter("studentscore.data");
			for(StudentScore score : scoreList) {
				out.write(score.toString() + "\n");
			}
			out.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void load() {
		try {
			FileReader in = new FileReader("studentscore.data");
			Scanner s = new Scanner(in);
			while(true) {
				try {
					scoreList.add(StudentScore.fromCSV(s.nextLine()));
				} catch (NoSuchElementException ex) {
					break;
				}
			}
			s.close();
			in.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}














