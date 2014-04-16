package episode.ex3;

public class Tomcat {
	public static void main(String[] args) {
		// 서블릿은 개발자가 만든다.
		Servlet s1 = new MyServlet();
		
		// TerminalFilter는 톰캣에 만들어져있다.
		Filter f1 = new TerminalFilter(s1);

		// 사용자가 추가한 필터
		//Filter f3 = new CharSetFilter(f1);
			
		// 사용자가 추가한 필터 
		//Filter f2 = new LogFilter(f3);
		
		
		
		// 서블릿의 실행을 요청하면 톰캣은 필터를 호출한다.
		f1.doFilter();
		
	}
}












