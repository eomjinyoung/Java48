package thread;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Test01 extends Frame {
	
	public Test01() {
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
			  System.exit(0);
			}
		});
	}
	
	public static void main(String[] args) {
		Test01 f = new Test01();
		f.setSize(400, 300);
	  f.setVisible(true);
		
		Thread t = Thread.currentThread();
		System.out.println("현재 스레드:" + t.getName());
		
		ThreadGroup tgMain = t.getThreadGroup();
		System.out.println("main의 스레드 그룹:" + tgMain.getName());
		
		ThreadGroup tgSystem = tgMain.getParent();
		System.out.println("main 스레드그룹의 상위:" + tgSystem.getName());
		
		//ThreadGroup tg3 = tg2.getParent();
		//System.out.println("system 스레드그룹의 상위:" + tg3.getName());
		
		//system 스레드그룹에 하위 스레드그룹
		printSubThreadGroup(tgSystem, "system/");
		
		//system 스레드그룹의 하위 스레드:
		printSubThread(tgSystem, "system/");
		
		printSubThreadGroup(tgMain, "system/main/");
		printSubThread(tgMain, "system/main/");
	}
	
	static private void printSubThreadGroup(ThreadGroup tg, String path) {
		ThreadGroup[] tgList = new ThreadGroup[10];
		int size = tg.enumerate(tgList, false);
		
		for(int i = 0; i < size; i++) {
			System.out.println(path + tgList[i].getName());	
		}
	}
	
	static private void printSubThread(ThreadGroup tg, String path) {
		Thread[] tList = new Thread[10];
		int size = tg.enumerate(tList, false);
		
		for(int i = 0; i < size; i++) {
			System.out.println(path + "(t)" + tList[i].getName());	
		}
	}

}


















