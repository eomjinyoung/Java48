package basic.exam05.step03;

/* 각 기능 별로 Control 클래스 분리
 * - 사용자가 입력한 데이터를 가공하여 Dao에게 전달
 * - Dao가 리턴한 데이터를 가공하여 Boundary에게 전달
 * - 일단, 현재는 Control이 Dao와 Boundary 역학을 겸한다. 
 * 
 */
import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Scanner;

public class StudentMgtSystem {
	static Scanner scanner = new Scanner(System.in);
	
	private static String promptMenu() {
		System.out.print("메뉴>");
		return scanner.nextLine().toLowerCase(); 
	}
	
	public static void main(String[] args) {
		class MyWindowListener implements WindowListener {
			public void windowClosing(WindowEvent e) {
				// 윈도우에서 X 버튼을 클릭할 때 호출됨.
				System.exit(0); // 0는 이상없이 종료함을 의미. JVM 종료. 				
			}
      public void windowOpened(WindowEvent e) {}
      public void windowClosed(WindowEvent e) {}
      public void windowIconified(WindowEvent e) {}
      public void windowDeiconified(WindowEvent e) {}
      public void windowActivated(WindowEvent e) {}
      public void windowDeactivated(WindowEvent e) {}
		}
		
		MyWindowListener listener = new MyWindowListener();
		
		Frame f = new Frame("학생관리시스템");
		f.setSize(400, 300);
		f.addWindowListener(listener);
		
		f.setVisible(true);
		/*
		do {
			String menu = promptMenu();
			
			if ("1".equals(menu)) {
				StudentControl.execute();
			} else if ("2".equals(menu)) {
				StudentScoreControl.execute();
			} else if ("list".equals(menu)) {
				System.out.println("1 학생관리");
				System.out.println("2 점수관리");
				System.out.println("q 종료");
			} else if ("q".equals(menu)) {
				break;
			} else {
				System.out.println("없는 메뉴입니다.");
			}
			
		} while(true);
		*/
		scanner.close();
	}
}













