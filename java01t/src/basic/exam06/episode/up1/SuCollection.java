package basic.exam06.episode.up1;

// 객체들의 목록을 다루는 기능을 통일하여 정의.
public class SuCollection {
	int length;
	
	public void add(Object value) {}
	public void insert(int index, Object value) {}
	public Object get(int index) {return null;}
	
	public int size() {
		return length;
	}
}
