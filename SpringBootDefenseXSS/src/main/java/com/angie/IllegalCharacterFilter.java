/**
 * 
 */
package com.angie;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * 非法字符过滤器，用来处理request.getParamater中的非法字符。如<script>alert('123');</script>
 * 
 * @author Angie
 * github:https://github.com/Angie520
 * @date 2017年4月1日 下午3:08:29
 */
public class IllegalCharacterFilter implements Filter {
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws ServletException, IOException {
		HttpServletRequest request = (HttpServletRequest)req;
		request = new MHttpServletRequest(request);
		chain.doFilter(request, res);
	}
	
	@Override
    public void destroy() {

    }
	
}
