package com.shinelon.cachedemo.config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.slf4j.MDC;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@WebFilter(urlPatterns="/*")
@Order(1)
@Component
public class MdcFilter implements Filter {

	private static final String REQUEST_KEY = "request";

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		insertIntoMDC(request);
		try {
			chain.doFilter(request, response);
		} finally {
			clearMDC();
		}

	}

	private void insertIntoMDC(ServletRequest request) {
		MDC.put(REQUEST_KEY, request.hashCode()+"|" + System.currentTimeMillis());
	}

	private void clearMDC() {
		MDC.remove(REQUEST_KEY);
	}

	@Override
	public void destroy() {

	}

}
