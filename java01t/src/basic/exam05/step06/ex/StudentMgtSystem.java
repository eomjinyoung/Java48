package basic.exam05.step06.ex;

import java.awt.CardLayout;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class StudentMgtSystem /* 적절한 클래스를 상속 받으시오 */ {
	public static final String MENU_PANEL = "MenuPanel";
	public static final String STUDENT_PANEL = "StudentPanel";
	public static final String SCORE_PANEL = "ScorePanel";
	
	MenuPanel menuPanel;
	ScorePanel scorePanel;
	
	StateChangeListener stateChangeListener = new StateChangeListener() {
		@Override
    public void stateChanged(StateChangeEvent e) {
			/* 자식 윈도우의 상태 변화에 따라 
			 * 카드 윈도우를 교체하는 코드를 작성하시오 */
    }
	};
	
	public StudentMgtSystem() {
		super("학생관리시스템"); 
		setSize(800, 600);
		
		addWindowListener(
				/* 종료 이벤트에 반응하는 적절한 윈도우 리스너를 작성하시오
				 * 종료시 점수를 저장해야 합니다. 
				 * */);
		
		setLayout(new CardLayout()); 
		
		menuPanel = new MenuPanel();
		scorePanel = new ScorePanel();
		
		menuPanel.addStateChangeListener(stateChangeListener);
		scorePanel.addStateChangeListener(stateChangeListener);
		
		add(menuPanel, MENU_PANEL);
		add(scorePanel, SCORE_PANEL);
		
	}
	
	public static void main(String[] args) {
		StudentMgtSystem f = new StudentMgtSystem();
		f.setVisible(true);
	}
	

}













