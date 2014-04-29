package sems.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthFilter implements Filter {

	@Override
	public void destroy() {}

	@Override
	public void doFilter(
			ServletRequest request, ServletResponse response,
	    FilterChain next) throws IOException, ServletException {
		
		// doFilter()가 호출될 때 넘어 오는 파라미터는 
		// HttpServletRequest와 HttpServletResponse 이다.
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		HttpServletResponse httpResponse = (HttpServletResponse)response;
		
		// 1) 클라이언트가 요청한 URL 정보를 가져온다.
		String servletPath = httpRequest.getServletPath();
		
		// 2) 만약 URL에 '/auth/' 문자열을 포함하고 있지 않다면
		//    로그인 여부 검사한다.
		if (!servletPath.startsWith("/auth/")) {
			HttpSession session = httpRequest.getSession();
			if (session.getAttribute("loginUser") == null) {
				String contextRoot= httpRequest.getContextPath(); // "/web01"
				httpResponse.sendRedirect(contextRoot + "/auth/login.bit");
				//  "/web01/auth/login.bit"
				return;
			}
		}
		
		next.doFilter(request, response);
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {}

}













