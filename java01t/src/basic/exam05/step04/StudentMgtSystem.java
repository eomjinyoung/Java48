package basic.exam05.step04;

/* 
 * 
 */
import java.awt.Button;
import java.awt.CardLayout;
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
@SuppressWarnings("serial")
public class StudentMgtSystem extends Frame {
	public static final String MENU_PANEL = "MenuPanel";
	public static final String STUDENT_PANEL = "StudentPanel";
	public static final String SCORE_PANEL = "ScorePanel";
	
	MenuPanel menuPanel;
	StudentPanel studentPanel;
	ScorePanel scorePanel;
	
	
	public StudentMgtSystem() {
		super("학생관리시스템"); 
		setSize(400, 300);
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0); 		
			}
		});
		
		setLayout(new CardLayout()); // 메뉴화면,학생관리화면,점수관리화면 겹치게 함.
		
		menuPanel = new MenuPanel(this);
		studentPanel = new StudentPanel(this);
		scorePanel = new ScorePanel(this);
		
		// CardLayout인 경우 자식 컴포넌트를 붙일 때 
		// 이름을 함께 주어야 한다.
		add(menuPanel, MENU_PANEL);
		add(studentPanel, STUDENT_PANEL);
		add(scorePanel, SCORE_PANEL);
		
	}
	
	// 자식 패널들이 호출한다.
	public void changePanel(String panelName) {
		CardLayout cardLayout = (CardLayout)this.getLayout();
		
		cardLayout.show(this, panelName);
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
	}
	

}













