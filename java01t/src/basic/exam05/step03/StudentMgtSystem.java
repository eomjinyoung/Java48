package basic.exam05.step03;

/* 
 * 
 */
import java.awt.Button;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Scanner;

import javax.swing.JOptionPane;

/* Frame에 들어갈 화면 제작
 * 1) MenuPanel: 메뉴 출력 화면
 * 2) StudentPanel: 학생 관리 화면
 * 3) ScorePanel: 점수 관리 화면
 * 
 * 
 */
public class StudentMgtSystem extends Frame 
										implements ActionListener {
	static Scanner scanner = new Scanner(System.in);
	Panel menuPanel = new Panel();
	Button btnStudentMgt = new Button("학생관리");
	Button btnScoreMgt = new Button("점수관리");
	
	public StudentMgtSystem() {
		super("학생관리시스템"); // 호출할 수퍼 클래스 생성자를 지정할 수 있다.
		//super(); // 호출할 수퍼 클래스 생성자를 지정하지 않는다면 기본 생성자 호출함.
		//setTitle("학생관리시스템"); // 기본 생성자 호출후 setTitle()를 호출해도 됨.
		setSize(400, 300);
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0); 		
			}
		});
		
		setLayout(new FlowLayout());
		menuPanel.setPreferredSize(new Dimension(70, 70)); 
		add(menuPanel);
		
		btnStudentMgt.addActionListener(this);
		btnScoreMgt.addActionListener(this);
		
		menuPanel.add(btnStudentMgt);
		menuPanel.add(btnScoreMgt);
	}
	
	private static String promptMenu() {
		System.out.print("메뉴>");
		return scanner.nextLine().toLowerCase(); 
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnStudentMgt) {
			JOptionPane.showMessageDialog(null, "학생관리");
		} else { // btnScoreMgt
			JOptionPane.showMessageDialog(null, "점수관리");
		}
		
	}
	
	public static void main(String[] args) {
		StudentMgtSystem f = new StudentMgtSystem();
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













