package basic.exam05.step04;

import java.awt.Button;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class StudentPanel extends Panel implements ActionListener {
	StudentMgtSystem parent;
	Label title = new Label("학생관리");
	Button btnBack = new Button("뒤로");

	public StudentPanel(StudentMgtSystem parent) {
		this.parent = parent; // 부모 윈도우의 주소를 보관
		add(title);
		btnBack.addActionListener(this);
		add(btnBack);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		parent.changePanel(StudentMgtSystem.MENU_PANEL);
	}
}








