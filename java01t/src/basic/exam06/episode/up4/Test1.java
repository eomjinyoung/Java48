package basic.exam06.episode.up4;

// 사용하는 객체(의존 객체; dependency object)가 클래스이면
// 융통성이 떨어진다. 유지보수가 어려워진다.
// => 클래스보다 융통성이 높은 인터페이스를 사용한다.
public class Test1 {
	static Collection coll;
	
	public static void testAdd() {
			coll.add("홍길동");
			coll.add("임꺽정");
			coll.add("장보고");
			coll.insert(2, "장길산");
	}
	
	public static void testList() {
		for (int i = 0; i < coll.size(); i++) {
			System.out.println( coll.get(i) );
		}
	}
	
	public static void main(String[] args) {
		coll = new Collection6();
		
		try {
			testAdd();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			testList();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}

















