package com.baalam.util;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;



public class RequestEncodeFilter implements Filter {
	
	private FilterConfig filterConfig = null;
	
	public RequestEncodeFilter() {
		System.out.println("Request response encoder Filter object has been created");
	}
	
	public void init(FilterConfig filterConfig) {
		this.setFilterConfig(filterConfig);
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		chain.doFilter(request, response);
	}
	
	public void destroy() {
		this.setFilterConfig(null);
	}

	public FilterConfig getFilterConfig() {
		return filterConfig;
	}

	public void setFilterConfig(FilterConfig filterConfig) {
		this.filterConfig = filterConfig;
	}
	
}
