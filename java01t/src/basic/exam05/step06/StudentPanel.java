package basic.exam05.step06;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;


@SuppressWarnings("serial")
public class StudentPanel extends ContentPanel {
	StudentControl controller = new StudentControl();
	
	List listView = new List(){
		public Dimension getPreferredSize() {
			return new Dimension(300, 400);
		};
	};
	
	Panel detailView = new Panel(new FlowLayout(FlowLayout.LEFT));
	TextField tfName = new TextField(10);
	TextField tfAge = new TextField(3);
	TextField tfTel = new TextField(15);
	TextField tfEmail = new TextField(20);
	TextField tfAddr = new TextField(20);
	Panel newButtonBar;
	Panel detailButtonBar;
	Button btnAdd = new Button("등록");
	Button btnUpdate = new Button("변경");
	Button btnDelete = new Button("삭제");
	Button btnCancel = new Button("취소");
	
	int selectedIndex = -1;
	
	public StudentPanel() {
		super("학생관리");
		
		listView.setMultipleMode(false);
		listView.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				Student s = Student.fromCSV(
						listView.getItem(
								listView.getSelectedIndex()));
				tfName.setText(s.name);
				tfAge.setText(Integer.toString(s.age));
				tfTel.setText(s.tel);
				tfEmail.setText(s.email);
				tfAddr.setText(s.address);
				
				newButtonBar.setVisible(false);
				detailButtonBar.setVisible(true);
				StudentPanel.this.validate();
				
				selectedIndex = listView.getSelectedIndex();
			}
		});
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
		
		newButtonBar = createRowPane();
		newButtonBar.add(btnAdd);
		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Student s = new Student();
				s.name = tfName.getText();
				s.age = Integer.parseInt(tfAge.getText());
				s.tel = tfTel.getText();
				s.email = tfEmail.getText();
				s.address = tfAddr.getText();
				
				controller.add(s);
				listView.add(s.toString());
				clearForm();
			}
		});
		detailView.add(newButtonBar);
		
		detailButtonBar = createRowPane();
		detailButtonBar.setVisible(false);
		detailButtonBar.add(btnUpdate);
		detailButtonBar.add(btnDelete);
		detailButtonBar.add(btnCancel);
		
		btnUpdate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Student s = new Student();
				s.name = tfName.getText();
				s.age = Integer.parseInt(tfAge.getText());
				s.tel = tfTel.getText();
				s.email = tfEmail.getText();
				s.address = tfAddr.getText();
				
				controller.update(selectedIndex, s);
				listView.replaceItem(s.toString(), selectedIndex);
			}
		});
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				newButtonBar.setVisible(true);
				detailButtonBar.setVisible(false);
				listView.remove(selectedIndex);
				controller.remove(selectedIndex);
				clearForm();
			}
		});
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				newButtonBar.setVisible(true);
				detailButtonBar.setVisible(false);
				selectedIndex = -1;
				clearForm();
			}
		});
		detailView.add(detailButtonBar);
		
		
		
		content.add(detailView);
		
		
		controller.load();
		displayList();
	}
	
	private void clearForm() {
    tfName.setText("");
    tfAge.setText("");
    tfTel.setText("");
    tfEmail.setText("");
    tfAddr.setText("");
  }
	
	private void displayList() {
	  for (Student student : controller.studentList) {
	  	listView.add(student.toString());
	  }
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
	
	public void save() {
		controller.save();
	}
}




























