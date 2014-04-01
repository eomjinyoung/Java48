package basic.exam05.step06.ex;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class ContentPanel /* 적절한 클래스와 인터페이스를 선언하시오 */ {
	protected Label title = new Label();
	protected Button btnBack = new Button("뒤로");
	protected Panel content = new Panel();
	protected Panel titlebar = new Panel();
	
	/* 이벤트 리스너들을 저장할 컬렉션 객체를 선언하시오 */
	
	public ContentPanel(String title) {
		this.setLayout(new BorderLayout());
		
		this.title.setText(title);
		
		titlebar.add(this.title);
		titlebar.add(btnBack);
		this.add(titlebar, BorderLayout.NORTH);
		
		this.add(content, BorderLayout.CENTER);
		
		btnBack.addActionListener(this);
	}
	
	public ContentPanel(String title, boolean showTitleBar) {
		this(title);
		
		titlebar.setVisible(showTitleBar);
	}

	@Override
  public void actionPerformed(ActionEvent e) {
	  fireEvent(new StateChangeEvent(this, "back"));
  }
	
	/* 적절한 이벤트 관련 메서드들을 선언하시오 */
	
	
	
}














