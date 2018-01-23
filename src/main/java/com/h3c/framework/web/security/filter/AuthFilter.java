package com.h3c.framework.web.security.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.h3c.framework.util.ResourceUtil;
import com.h3c.framework.util.SafetyUtil;

/**
 * 
 * 权限核心过滤器
 * @author 周兆巍
 * @version 创建时间：2014年12月1日 下午3:56:26
 */
public class AuthFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AuthFilter() {
    }

	/**
	 * @see Filter#destroy()
	 */
	@Override
	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		response.setContentType("text/html;charset=utf-8");
		HttpServletRequest rq = (HttpServletRequest) request;
		HttpServletResponse rs = (HttpServletResponse) response;
		String requestPath = ResourceUtil.getRequestPath(rq);

		if (rq.getSession().getAttribute("cUser") == null) {
	        if(SafetyUtil.checkIsExcludeUrl(requestPath)){
	        	chain.doFilter(request, response);
	        	return ;
	        } 		
		    //判断如果当前页面不为主框架，则将主框架进行跳转(解决iframe窗体丢失Session时登录窗口显示在子页面的问题)
			rs.sendRedirect(rq.getContextPath()+"/pages/login/Timeout.html");
		} else {
			// if(requestPath.indexOf(".do")!=-1){
			// @SuppressWarnings("unchecked")
			// Map<String,Integer> map =
			// (Map<String,Integer>)rq.getSession().getAttribute("psRoleFunction");
			// if((map!=null)&&(map.get(requestPath)!=null)){
			// rs.sendRedirect(rq.getContextPath()+"/pages/login/Timeout.html");
			// return ;
			// }
			// }
			/*
			 * 使用 X-Frame-Options 有三个可选的值：
			 * DENY：浏览器拒绝当前页面加载任何Frame页面
			 * SAMEORIGIN：frame页面的地址只能为同源域名下的页面
			 * ALLOW-FROM：允许frame加载的页面地址
			 */
			rs.addHeader("X-Frame-Options", "SAMEORIGIN");// 20170109
			chain.doFilter(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	@Override
	public void init(FilterConfig fConfig) throws ServletException {

	}

}
