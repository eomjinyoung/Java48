package episode.ex3;

public class CharSetFilter implements Filter {
	Filter nextFilter;
	
	public CharSetFilter(Filter nextFilter) {
		this.nextFilter = nextFilter;
	}
	
	@Override
	public void doFilter() {
		System.out.println("클라이언트 문자집합 설정하기...");
		
		nextFilter.doFilter();

	}

}













