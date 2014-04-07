package basic.exam06.episode;

// 객체 주소들을 보관
public class Collection {
	Object[] list;
	int cursor;
	
	public Collection() {
		list = new Object[1000];
	}
	
	public Collection(int initSize) {
		list = new Object[initSize];
	}
	
	public void add(Object obj) throws Exception {
		if (cursor < list.length) {
			list[cursor] = obj;
		} else {
			throw new Exception("인덱스가 배열 크기를 초과했다!");
		}
	}
	
	public Object get(int index) {
		return null;
	}
	
	public int size() {
		return 0;
	}
}




