package com.dc.filter;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RequestLoggingFilter implements Filter {

	private ServletContext context;
	
	private static final Logger log = LoggerFactory.getLogger(RequestLoggingFilter.class);
	
	@Override
	public void init(FilterConfig config) throws ServletException {
		
		this.context = config.getServletContext();
		this.context.log("RequestLoggingFilter initialized");
		log.debug("RequestLoggingFilter initialized");
	}
	
	

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		Enumeration<String> params = req.getParameterNames();
		
		while(params.hasMoreElements()){
			String name = params.nextElement();
			String value = request.getParameter(name);
			this.context.log(req.getRemoteAddr() + "::Request Params::{"+name+"="+value+"}");
		}
		
		Cookie[] cookies = req.getCookies();
		if(cookies != null){
			for(Cookie cookie : cookies){
				this.context.log(req.getRemoteAddr() + "::Cookie::{"+cookie.getName()+","+cookie.getValue()+"}");
				System.out.println("user address"  +req.getRemoteAddr() );
			}
		}
		// pass the request along the filter chain
		chain.doFilter(request, response);
		
	}

	@Override
	public void destroy() {
		
	}

}
