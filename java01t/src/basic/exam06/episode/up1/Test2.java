package basic.exam06.episode.up1;

// 아무런 구현을 하지 않은 SuCollection 사용할 경우
// - 사용을 막지 못한다.
// - 해결책? 일반적인 용도로 사용하지 못하게 추상 클래스로 선언한다.
//          up2 패키지 참조!
public class Test2 {
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
		coll = new SuCollection();
		
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

















