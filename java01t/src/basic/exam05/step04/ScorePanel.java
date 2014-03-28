package basic.exam05.step04;

import java.awt.Label;
import java.awt.Panel;

@SuppressWarnings("serial")
public class ScorePanel extends Panel {
	StudentMgtSystem parent;
	Label title = new Label("점수관리");
	
	public ScorePanel(StudentMgtSystem parent) {
		this.parent = parent; // 부모 윈도우의 주소를 보관
		add(title);
	}
}
