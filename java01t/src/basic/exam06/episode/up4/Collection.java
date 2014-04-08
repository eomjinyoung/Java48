package basic.exam06.episode.up4;

// 인터페이스
// - 사용 객체와 의존 객체 사이의 규칙을 정의
// - caller와 callee 사이의 규칙을 정의
// - 어떤 객체가 가져야할 자격(기능)을 정의
// - 인터페이스에 선언된  모든 메서드는 추상 메서드이다.
//   public abstact 메서드.
// - 인터페이스에 선언된 모든 변수는 상수이다.
//   public static final 변수.
// - 인터페이스를 정의하면,
//   한쪽 개발자는 해당 규칙에 따라 메서드를 호출하는 프로그램을 짜고,
//   다른쪽 개발자는 규칙에 따라 호출될 메서드를 만든다.
//
// 아래의 Collection 인터페이스는
// - 객체 목록을 다루는 자가 가져야 할 자격을 정의한다.
// - 객체 목록을 사용하는 자와 객체 목록을 보관하는 자 사이의 규칙을 정의
public interface Collection {
	/*public abstract*/ void add(Object value);
	/*public abstract*/ void insert(int index, Object value);
	/*public abstract*/ Object get(int index);
	int size();
}



















