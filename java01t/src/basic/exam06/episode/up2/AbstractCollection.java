package basic.exam06.episode.up2;

// 추상 클래스
// - 직접 쓰이지 않는다.
// - 하위 클래스에게 공통 속성 및 기능을 상속해 주는 용도로 사용한다. 
public abstract class AbstractCollection {
	int length;
	
	public void add(Object value) {}
	public void insert(int index, Object value) {}
	public Object get(int index) {return null;}
	
	public int size() {
		return length;
	}
}
