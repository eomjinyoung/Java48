package basic.exam05.step04;

import java.awt.Label;
import java.awt.Panel;

@SuppressWarnings("serial")
public class StudentPanel extends Panel {
	StudentMgtSystem parent;
	Label title = new Label("학생관리");
	
	public StudentPanel(StudentMgtSystem parent) {
		this.parent = parent; // 부모 윈도우의 주소를 보관
		add(title);
	}
}
