package basic.exam05.step05;

/* 
 * 
 */
import java.awt.CardLayout;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/* 상속
 * 1) specialization 
 * - 수퍼클래스로부터 상속받아서 기능을 덧붙임 => 특화시킴.
 * 
 *  2) generalization
 *  - 서브클래스들의 공통점을 찾아 수퍼클래스로 정의한다.
 *  - 그리고 수퍼클래스를 상속받는다.
 *  
 *  목표: ScorePanel, StudentPanel의 공통점을 찾아 ContentPanel로 정의
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













