package episode.ex3;

public class LogFilter implements Filter {
	Filter nextFilter;
	
	public LogFilter(Filter nextFilter) {
		this.nextFilter = nextFilter;
	}
	
	@Override
	public void doFilter() {
		System.out.println("서블릿 실행 전에 로그 남기기...");
		
		nextFilter.doFilter();

		System.out.println("서블릿 실행 후에 로그 남기기...");
	}

}
