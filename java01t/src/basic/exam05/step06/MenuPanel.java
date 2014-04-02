package basic.exam05.step06;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class MenuPanel extends ContentPanel implements ActionListener {
	Button btnStudentMgt = new Button("학생관리");
	Button btnScoreMgt = new Button("점수관리");
	Button btnLectureMgt = new Button("강의관리");
	
	public MenuPanel() {
		super("메뉴", false);
		// 생성자에서 자식 컴포넌트들을 준비한다.
		btnStudentMgt.addActionListener(this);
		btnScoreMgt.addActionListener(this);
		btnLectureMgt.addActionListener(this);
		
		this.content.add(btnStudentMgt);
		this.content.add(btnScoreMgt);	
		this.content.add(btnLectureMgt);	
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnStudentMgt) {
			this.fireEvent(new StateChangeEvent(this, "studentPanel"));
			
		} else if (e.getSource() == btnScoreMgt)  { // btnScoreMgt
			this.fireEvent(new StateChangeEvent(this, "scorePanel"));
			
		} else if (e.getSource() == btnLectureMgt) { // btnLectureMgt
			this.fireEvent(new StateChangeEvent(this, "lecturePanel"));
		}
		
	}
	
}













