package basic.exam06.episode;

public class Test2 {
	static Collection2 coll = new Collection2(4);
	
	public static void testAdd() {
		//try {
			coll.add("홍길동");
			coll.add("임꺽정");
			coll.insert(0, "장길산");
		//} catch (Throwable e) {
		//		System.out.println("헐.. 니가 보고할려고.. 어이가 없다. 안돼!");
		//}
		
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

















