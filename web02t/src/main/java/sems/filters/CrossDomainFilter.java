package sems.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

@WebFilter("*.ajax")
public class CrossDomainFilter implements Filter{

	@Override
  public void init(FilterConfig filterConfig) throws ServletException {}

	@Override
  public void doFilter(ServletRequest request, ServletResponse response,
      FilterChain chain) throws IOException, ServletException {
		
	  HttpServletResponse resp = (HttpServletResponse)response;
	  resp.setHeader("Access-Control-Allow-Origin", "*");
	  chain.doFilter(request, response);
  
	}

	@Override
  public void destroy() {}

}












