package basic.exam06.episode;

public class Test3 {
	static Collection3 coll = new Collection3();
	
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

















