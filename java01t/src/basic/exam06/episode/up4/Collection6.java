package basic.exam06.episode.up4;

import java.util.ArrayList;

// 위임(delegation)방식을 이용하여 결합을 느슨하게 한다.
// - ArrayList를 직접 상속 받지않고
// - 의존 객체로 사용하면 => 결합이 느슨해져서 확장성이 좋아진다.
public class Collection6 implements Collection {

	// 상속이 아닌 위임이라는 방법을 사용하면 
	// 훨씬 더 유지보수가 좋은 구조가 된다.
	ArrayList<Object> 전문경영인 = new ArrayList<Object>();
	
	@Override
  public void insert(int index, Object value) {
	  전문경영인.add(index, value);
  }
	
	@Override
  public void add(Object value) {
	  전문경영인.add(value);
	  
  }
	
	@Override
  public Object get(int index) {
	  return 전문경영인.get(index);
  }

	@Override
  public int size() {
	  return 전문경영인.size();
  }
	

	

}











