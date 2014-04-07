package basic.exam06.episode.up1;

public class Test1 {
	static SuCollection coll;
	
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
		coll = new Collection3();
		
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

















