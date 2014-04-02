package basic.exam05.step06;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class LectureControl {
	public ArrayList<Lecture> lectureList 
												= new ArrayList<Lecture>();
	
	public void add(final Lecture lecture) {
		lectureList.add(lecture);
	}
	
	public void remove(final int no) {
		lectureList.remove(no);
  }
	
	public void update(final int no, final Lecture lecture) {
		lectureList.set(no, lecture);
  }
	
	public void save() {
		try {
			FileWriter out = new FileWriter("lecture.data");
			for(Lecture lecture : lectureList) {
				out.write(lecture.toString() + "\n");
			}
			out.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void load() {
		try {
			FileReader in = new FileReader("lecture.data");
			Scanner s = new Scanner(in);
			while(true) {
				try {
					lectureList.add(Lecture.fromCSV(s.nextLine()));
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














