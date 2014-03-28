package basic.exam05.step03;

/* LayoutManager
 * - 컨테이너에 UI 컴포넌트를 위치시키는 역할을 담당
 * 1) BorderLayout
 * - 동,서,남,북,가운데 
 * 2) FlowLayout
 * - 왼쪽에서 오른쪽으로 배치 => 끝을 만나면 다음 라인에 이어서 배치
 * 3) GridLayout
 * - 바둑판 방식으로 배치 => 모든 셀의 너비와 높이가 같다.
 * 4) CarLayout
 * - 중첩하여 배치 => 탭화면을 만들 때
 * 5) GridBagLayout
 * - GridLayout + 셀 병합기능 추가 
 * 
 */
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class StudentMgtSystem02 {
	static Scanner scanner = new Scanner(System.in);
	
	private static String promptMenu() {
		System.out.print("메뉴>");
		return scanner.nextLine().toLowerCase(); 
	}

	public static void main(String[] args) {
		Frame f = new Frame("학생관리시스템");
		f.setSize(400, 300);
		
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0); 		
			}
		});
		
		Panel p = new Panel();// 기본 FlowLayout
		// FlowLayout은 자식 컴포넌트를 배치할 때 
		// 자식 컴포넌트가 원하는 크기를 먼저 알아낸 다음에
		// 부모 컨테이너의 크기를 결정한다. => 자식 컴포넌트를 배치한다.
		//p.setSize(50, 70); // 기본 크기
		//p.setMaximumSize(new Dimension(30, 70)); //최대크기
		p.setPreferredSize(new Dimension(70, 70)); // 이랬으면 하는 크기
		
		Button btnStudentMgt = new Button("학생관리");
		// 버튼 및 메뉴인 경우 MouseClick 또는 KeyPress 이벤트가 발생했을 때
		// Action 이벤트를 추가로 발생시킨다.
		btnStudentMgt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "오호라 이거야..");
				
			}
		});
		/*btnStudentMgt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "눌렀음");
				
			}
		});
		btnStudentMgt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				JOptionPane.showMessageDialog(null, "키 눌렀음");
				
			}
		});
		*/
		
		Button btnScoreMgt = new Button("점수관리");
		
		p.add(btnStudentMgt);
		p.add(btnScoreMgt);
		
		f.setLayout(new FlowLayout());
		f.add(p);
		
		f.setVisible(true);
		/*
		do {
			String menu = promptMenu();
			
			if ("1".equals(menu)) {
				StudentControl.execute();
			} else if ("2".equals(menu)) {
				StudentScoreControl.execute();
			} else if ("list".equals(menu)) {
				System.out.println("1 학생관리");
				System.out.println("2 점수관리");
				System.out.println("q 종료");
			} else if ("q".equals(menu)) {
				break;
			} else {
				System.out.println("없는 메뉴입니다.");
			}
			
		} while(true);
		*/
		scanner.close();
	}
	

}













