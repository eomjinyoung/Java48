package basic.exam05.step03;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Episode02 {

	public static void main(String[] args) {
		// GridLayout
		// - 바둑판식 배치 => 모든 칸의 너비와 높이가 같다.
		// - 컨테이너.add(컴포넌트); 
		Frame f = new Frame("FlowLayout 테스트");
		f.setSize(400, 300);
		
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0); 		
			}
		});
		
		// row 개수를 기준으로 배치
		// => row 개수로 컬럼의 개수가 결정
		//f.setLayout(new GridLayout(3,4)); 
		
		// row가 0이면 column 개수에 따라 row 개수가 계산된다.
		f.setLayout(new GridLayout(0,2)); // row = 4
		//f.setLayout(new GridLayout(0,3)); // row = 3
		//f.setLayout(new GridLayout(0,4)); // row = 2 
		
		f.add(new Button("버튼1"));
		f.add(new Button("버튼2"));
		f.add(new Button("버튼3"));
		f.add(new Button("버튼4"));
		f.add(new Button("버튼5"));
		f.add(new Button("버튼6"));
		f.add(new Button("버튼7"));
		f.add(new Button("버튼8"));
		
		f.setVisible(true);

	}
	
	public static void main02(String[] args) {
		// FlowLayout
		// - Panel 컨테이너의 기본 UI배치 관리자다.
		// - 컨테이너.add(컴포넌트); => 물 흐르듯이 왼쪽 -> 오른쪽, 위 -> 아래
		Frame f = new Frame("FlowLayout 테스트");
		f.setSize(400, 300);
		
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0); 		
			}
		});
		
		f.setLayout(new FlowLayout(FlowLayout.LEFT)); // 기본 레이아웃 관리자를 FlowLayout으로 교체
		
		f.add(new Button("버튼1"));
		f.add(new Button("버튼2"));
		f.add(new Button("버튼3"));
		f.add(new Button("버튼4"));
		f.add(new Button("버튼5"));
		f.add(new Button("버튼6"));
		
		f.setVisible(true);

	}
	
	public static void main01(String[] args) {
		// BorderLayout
		// - Frame 컨테이너의 기본 UI배치 관리자다.
		// - 컨테이너.add(컴포넌트, 위치지정(동,서,남,북,가운데));
		// - 컨테이너.add(컴포넌트); => 기본으로 가운데에 배치시킨다.
		Frame f = new Frame("BorderLayout 테스트");
		f.setSize(400, 300);
		
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0); 		
			}
		});
		
		f.add(new Button("버튼1"), BorderLayout.NORTH);
		f.add(new Button("버튼2"), BorderLayout.EAST);
		f.add(new Button("버튼3"), BorderLayout.SOUTH);
		f.add(new Button("버튼4"), BorderLayout.WEST);
		f.add(new Button("버튼5"), BorderLayout.CENTER);
		f.add(new Button("버튼6"));
		
		f.setVisible(true);

	}

}







