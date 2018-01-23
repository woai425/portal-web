package com.h3c.framework.web.security.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.util.StringUtils;

/**
 * *********************************************************************
 * CSRF攻击过滤器,处理CSRF攻击 CsrfFilter.java
 *
 * H3C所有， 受到法律的保护，任何公司或个人，未经授权不得擅自拷贝。
 * 
 * @copyright Copyright: 2015-2020
 * @creator z10926<br/>
 * @create-time 2016年7月20日 上午9:22:25
 * @revision $Id: *
 **********************************************************************
 */
public class CsrfFilter implements Filter {

	private String referer;

	/**
	 * Default constructor.
	 */
	public CsrfFilter() {

	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {

	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
			ServletException {

		// HTTP请求头来源校验,如果来源不合法就抛异常出去
		HttpServletRequest req = (HttpServletRequest) request;
		if (StringUtils.isEmpty(referer)) {
			chain.doFilter(request, response);
			return;
		}
		String refererHeader = req.getHeader("Referer");
		if (StringUtils.isEmpty(refererHeader)) {
			chain.doFilter(request, response);
			return;
		}
		
		String[] refererHeaders = referer.split(",");
		for(String header : refererHeaders){
			// 判断 Referer 是否以配置的referer值开头
			if ((!StringUtils.isEmpty(refererHeader)) && (refererHeader.trim().startsWith(header))) {
				chain.doFilter(request, response);
				return ;
			}
		}
		throw new RuntimeException("HTTP请求来源不合法!");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		this.referer = fConfig.getInitParameter("referer");
	}

}
