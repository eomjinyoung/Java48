package basic.exam05.step06;

import java.awt.Button;
import java.awt.Choice;
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
import java.sql.Date;


@SuppressWarnings("serial")
public class LecturePanel extends ContentPanel {
	LectureControl controller = new LectureControl();
	
	List listView = new List(){
		public Dimension getPreferredSize() {
			return new Dimension(300, 500);
		};
	};
	
	Panel detailView = new Panel(new FlowLayout(FlowLayout.LEFT));
	TextField tfTitle = new TextField(20);
	TextField tfTeacher = new TextField(15);
	TextField tfStartDate = new TextField(14);
	TextField tfEndDate = new TextField(14);
	Choice chClassroom = new Choice();
	Choice chManager = new Choice();
	Choice	chHours = new Choice();
	
	Panel newButtonBar;
	Panel detailButtonBar;
	Button btnAdd = new Button("등록");
	Button btnUpdate = new Button("변경");
	Button btnDelete = new Button("삭제");
	Button btnCancel = new Button("취소");
	
	int selectedIndex = -1;
	
	public LecturePanel() {
		super("강의관리");
		
		listView.setMultipleMode(false);
		listView.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				Lecture lecture = Lecture.fromCSV(
						listView.getItem(
								listView.getSelectedIndex()));
				tfTitle.setText(lecture.title);
				tfTeacher.setText(lecture.teacher);
				tfStartDate.setText(lecture.startDate.toString());
				tfEndDate.setText(lecture.endDate.toString());
				chClassroom.select(lecture.classroom);
				chManager.select(lecture.manager);
				chHours.select(Integer.toString(lecture.hours));
				
				newButtonBar.setVisible(false);
				detailButtonBar.setVisible(true);
				LecturePanel.this.validate();
				
				selectedIndex = listView.getSelectedIndex();
			}
		});
		content.add(listView);
		detailView.setPreferredSize(new Dimension(300,500));
		
		Panel rowPane = new Panel(new FlowLayout(FlowLayout.LEFT));
		rowPane.setPreferredSize(new Dimension(290, 50));
		rowPane.add(createLabel("과목"));
		rowPane.add(tfTitle);
		detailView.add(rowPane);
		
		rowPane = createRowPane();
		rowPane.add(createLabel("강사"));
		rowPane.add(tfTeacher);
		detailView.add(rowPane);
		
		rowPane = createRowPane();
		rowPane.add(createLabel("시작일"));
		rowPane.add(tfStartDate);
		detailView.add(rowPane);
		
		rowPane = createRowPane();
		rowPane.add(createLabel("종료일"));
		rowPane.add(tfEndDate);
		detailView.add(rowPane);
		
		rowPane = createRowPane();
		rowPane.add(createLabel("교실"));
		chClassroom.add("3-1");
		chClassroom.add("3-2");
		chClassroom.add("3-3");
		chClassroom.add("4-1");
		chClassroom.add("4-2");
		chClassroom.add("4-3");
		rowPane.add(chClassroom);
		detailView.add(rowPane);
		
		rowPane = createRowPane();
		rowPane.add(createLabel("관리자"));
		chManager.add("홍길동");
		chManager.add("임꺽정");
		chManager.add("장길산");
		rowPane.add(chManager);
		detailView.add(rowPane);
		
		rowPane = createRowPane();
		rowPane.add(createLabel("일강의시간"));
		chHours.add("4");
		chHours.add("5");
		chHours.add("6");
		chHours.add("7");
		chHours.add("8");
		rowPane.add(chHours);
		detailView.add(rowPane);
		
		newButtonBar = createRowPane();
		newButtonBar.add(btnAdd);
		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Lecture lecture = new Lecture();
				lecture.title = tfTitle.getText();
				lecture.teacher = tfTeacher.getText();
				lecture.startDate = Date.valueOf(tfStartDate.getText());
				lecture.endDate = Date.valueOf(tfEndDate.getText());
				lecture.classroom = chClassroom.getSelectedItem();
				lecture.manager = chManager.getSelectedItem();
				lecture.hours = Integer.parseInt(chHours.getSelectedItem());
				
				controller.add(lecture);
				listView.add(lecture.toString());
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
				Lecture lecture = new Lecture();
				lecture.title = tfTitle.getText();
				lecture.teacher = tfTeacher.getText();
				lecture.startDate = Date.valueOf(tfStartDate.getText());
				lecture.endDate = Date.valueOf(tfEndDate.getText());
				lecture.classroom = chClassroom.getSelectedItem();
				lecture.manager = chManager.getSelectedItem();
				lecture.hours = Integer.parseInt(chHours.getSelectedItem());
				
				controller.update(selectedIndex, lecture);
				listView.replaceItem(lecture.toString(), selectedIndex);
				
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
		tfTitle.setText("");
		tfTeacher.setText("");
		tfStartDate.setText("");
		tfEndDate.setText("");
		chClassroom.select(0);
		chManager.select(0);
		chHours.select(0);
  }
	
	private void displayList() {
	  for (Lecture lecture : controller.lectureList) {
	  	listView.add(lecture.toString());
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




























