package test;

import java.util.ArrayList;

public class eachTest {
	static ArrayList<String> list;
	
	static interface Closure {
		void each(Object value, int index);
	}
	
	public static void forEach(Closure f) {
		int index = 0;
		for (Object value : list) {
			f.each(value, index++);
		}
	}
	
	public static void main(String[] args) {
		list = new ArrayList();
		list.add("홍길동");
		list.add("임꺽정");
		list.add("장길산");
		
		forEach(new Closure() {
      public void each(Object value, int index) {
	      System.out.format("%1$s %2$d\n", value, index);
      }
		});
		
		Test04 p = new Test04();
		p.hello("홍길동");

	}

}












