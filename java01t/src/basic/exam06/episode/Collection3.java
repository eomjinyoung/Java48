package basic.exam06.episode;

public class Collection3 {
	class Box {
		Object value;
		Box next;
	}
	
	int length;
	Box start;
	Box end;
	
	public Collection3() {
		start = new Box();
		end = start;
	}
	
	public void add(Object obj) {
		end.value = obj;
		end.next = new Box();
		end = end.next;
		length++;
	}
	
	public Object get(int index) {
		if (index >= 0 && index < length) {
			Box cursor = start;
			int pos = 0;
			do {
				if (index == pos) {
					return cursor.value;
				} else {
					cursor = cursor.next;
				}
				pos++;
			} while (cursor != null);
			return cursor.value;
		} else {
			throw new RuntimeException("무효한 인덱스입니다.");
		}
	}
	
	public int size() {
		return length;
	}
	
	public void insert(int index, Object value) {
		if(index >= 0 && index < length) {

		}
	}
}

















