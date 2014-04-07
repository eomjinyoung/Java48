package basic.exam06.episode.up3;

// 추상 클래스
// - 직접 쓰이지 않는다.
// - 하위 클래스에게 공통 속성 및 기능을 상속해 주는 용도로 사용한다. 
public abstract class AbstractCollection {
	int length;
	
	// 하위 클래스가 재정의 해야할 메서드는 
	// 반드시 재정의하도록 강제함 => abstract 메서드 
	// 어차피 하위 클래스에서 재정의할 메서드라면 추상 메서드로 선언한다.
	public abstract void add(Object value);
	public abstract void insert(int index, Object value);
	public abstract Object get(int index);
	
	public int size() {
		return length;
	}
}
