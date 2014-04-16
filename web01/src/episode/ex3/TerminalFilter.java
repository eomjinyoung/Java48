package episode.ex3;

public class TerminalFilter implements Filter {
	Servlet worker;
	
	public TerminalFilter(Servlet worker) {
		this.worker = worker;
	}
	
	public void doFilter() {
		worker.service();
	}
}
