package controls;

import java.util.Map;

// 인터페이스 => 규칙 => 호출자, 피호출자 
// 호출자: Front Controller(DispatcherServlet)
// 피호출자: Page Controller(예: SubjectListControl, ...)
public interface PageController {
	String execute(Map<String,Object> model);
}
