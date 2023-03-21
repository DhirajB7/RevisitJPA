package com.learn.reLearningSpringBoot.configurations;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

@Component
public class SimpleFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletResponse responsee = (HttpServletResponse) response;
		HttpServletRequest requestt = (HttpServletRequest) request;
		
		
		List<String> headerNames = Collections.list(requestt.getHeaderNames());
		

		chain.doFilter(request, response);

	}

}
