package basic.exam06.episode.up2;

// RuntimeException을 사용하면 예외처리를 코딩하기가 쉬워진다.
// 즉 최상위 호출자에게 예외를 보고하는 효과를 지닌다.
// 직통 보고!
public class Collection2 extends AbstractCollection {
	Object[] list;
	
	public Collection2() {
		list = new Object[1000];
	}
	
	public Collection2(int initSize) {
		list = new Object[initSize];
	}
	
	@Override
	public void add(Object obj) {
		if (length < list.length) {
			list[length++] = obj;
			
		} else {
			throw new RuntimeException("인덱스가 배열 크기를 초과했다!");
		}
	}
	
	@Override
	public Object get(int index) {
		if (index >= 0 && index < list.length) {
			return list[index];
		} else {
			throw new RuntimeException("인덱스가 옳지 않습니다.");
		}
	}
	
	@Override
	public void insert(int index, Object value) {
		if(length < list.length && 
				index >= 0 && 
				index < list.length) {
			for(int i = length; i > index; i--) {
				list[i] = list[i-1];
			}
			
			list[index] = value;
			length++;
		}
	}
}

















