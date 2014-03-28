package basic.exam05.step05;

import java.awt.Button;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class MenuPanel extends Panel implements ActionListener {
	StudentMgtSystem parent;
	Button btnStudentMgt = new Button("학생관리");
	Button btnScoreMgt = new Button("점수관리");
	
	public MenuPanel(StudentMgtSystem parent) {
		this.parent = parent; // 부모 윈도우의 주소를 보관
		
		// 생성자에서 자식 컴포넌트들을 준비한다.
		btnStudentMgt.addActionListener(this);
		btnScoreMgt.addActionListener(this);
		
		add(btnStudentMgt);
		add(btnScoreMgt);	
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnStudentMgt) {
			parent.changePanel(StudentMgtSystem.STUDENT_PANEL);
		} else { // btnScoreMgt
			parent.changePanel(StudentMgtSystem.SCORE_PANEL);
		}
		
	}
	
}













