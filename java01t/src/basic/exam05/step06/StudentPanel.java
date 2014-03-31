package basic.exam05.step06;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;


@SuppressWarnings("serial")
public class StudentPanel extends ContentPanel {
	StudentControl controller = new StudentControl();
	
	TextArea listView = new TextArea();
	
	Panel detailView = new Panel(new FlowLayout(FlowLayout.LEFT));
	TextField tfName = new TextField(10);
	TextField tfAge = new TextField(3);
	TextField tfTel = new TextField(15);
	TextField tfEmail = new TextField(20);
	TextField tfAddr = new TextField(20);
	Button btnAdd = new Button("등록");
	
	public StudentPanel() {
		super("학생관리");
		
		listView.setPreferredSize(new Dimension(300, 400));
		content.add(listView);
		
		detailView.setPreferredSize(new Dimension(300,400));
		
		Panel rowPane = new Panel(new FlowLayout(FlowLayout.LEFT));
		rowPane.setPreferredSize(new Dimension(290, 50));
		rowPane.add(createLabel("이름"));
		rowPane.add(tfName);
		detailView.add(rowPane);
		
		rowPane = createRowPane();
		rowPane.add(createLabel("나이"));
		rowPane.add(tfAge);
		detailView.add(rowPane);
		
		rowPane = createRowPane();
		rowPane.add(createLabel("전화"));
		rowPane.add(tfTel);
		detailView.add(rowPane);
		
		rowPane = createRowPane();
		rowPane.add(createLabel("이메일"));
		rowPane.add(tfEmail);
		detailView.add(rowPane);
		
		rowPane = createRowPane();
		rowPane.add(createLabel("주소"));
		rowPane.add(tfAddr);
		detailView.add(rowPane);
		
		rowPane = createRowPane();
		rowPane.add(btnAdd);
		detailView.add(rowPane);
		
		content.add(detailView);
		
		controller.executeLoad();
		displayList();
	}
	
	private void displayList() {
		StringBuffer buf = new StringBuffer();
	  for (Student student : controller.studentList) {
	  	buf.append(student.toString() + "\n");
	  }
	  
	  listView.setText(buf.toString());
  }

	private Panel createRowPane() {
		Panel rowPane = new Panel(new FlowLayout(FlowLayout.LEFT));
		rowPane.setPreferredSize(new Dimension(290, 50));
		return rowPane;
	}
	
	private Label createLabel(String title) {
		Label label = new Label(title);
		label.setPreferredSize(new Dimension(70, 30));
		return label;
	}
}




























