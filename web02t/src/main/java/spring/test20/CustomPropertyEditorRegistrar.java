package spring.test20;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.beans.propertyeditors.CustomDateEditor;

public class CustomPropertyEditorRegistrar 
	implements PropertyEditorRegistrar{
	
	CustomDateEditor customDateEditor;
	
	public void setCustomDateEditor(CustomDateEditor customDateEditor) {
		this.customDateEditor = customDateEditor;
	}
	

	// 메서드 호출 순서
	// 1) 스프링 IoC 컨테이너가 beans.xml 파일을 읽는다.
	// 2) 빈을 생성한다.
	// 3) CustomEditorConfigurer 객체가 있는지 찾는다.=> 찾았으면!
	// 4) 커스텀 에디터 설정기가 갖고 에디터 등록기를 실행한다. (개수만큼 반복)
	// 5) 커스텀에디터등록기.registerCustomEditors(기록할 때 사용할 용지)
	// 6) registerCustomerEditors()에서는 "기록지"에 커스텀 에디터를 적는다.
	
	// Spring IoC Container 
	//		=> CustomerEditorConfigurer 실행
	// 			 => CustomerPropertyEditorRegistrar.registerCustomEditors() 호출 
	@Override
  public void registerCustomEditors(PropertyEditorRegistry registry) {
		registry.registerCustomEditor(
				java.util.Date.class, customDateEditor);
  }

}


















