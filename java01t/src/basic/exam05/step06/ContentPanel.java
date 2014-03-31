package basic.exam05.step06;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class ContentPanel extends Panel implements ActionListener{
	protected Label title = new Label();
	protected Button btnBack = new Button("뒤로");
	protected Panel content = new Panel();
	protected Panel titlebar = new Panel();
	
	protected ArrayList<StateChangeListener> listeners = 
			new ArrayList<StateChangeListener>();
	
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
	
	// 이벤트 관련 메서드 정의 
	public void addStateChangeListener(StateChangeListener l) {
		listeners.add(l);
	}
	
	public void removeStateChangeListener(StateChangeListener l) {
		listeners.remove(l);
	}
	
	public void fireEvent(StateChangeEvent e) {
		for(StateChangeListener l : listeners) {
			l.stateChanged(e);
		}
	}
	
	
}














