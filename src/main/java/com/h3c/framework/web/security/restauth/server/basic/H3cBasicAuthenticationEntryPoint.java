package com.h3c.framework.web.security.restauth.server.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;

/**
 * *********************************************************************
 * 基本认证入口扩展类
 * PortalBasicAuthenticationEntryPoint.java
 *
 * H3C所有，
 * 受到法律的保护，任何公司或个人，未经授权不得擅自拷贝。
 * @copyright   Copyright: 2015-2020
 * @creator     z10926<br/>
 * @create-time 2016年5月11日 下午2:04:14
 * @revision    $Id:  *
 **********************************************************************
 */
@Deprecated
public class H3cBasicAuthenticationEntryPoint extends
		BasicAuthenticationEntryPoint {

	@Override
	public void commence(HttpServletRequest request,
			HttpServletResponse response, AuthenticationException authEx)
			throws IOException, ServletException {
		response.addHeader("WWW-Authenticate", "Basic realm=\""
				+ getRealmName() + "\"");
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		PrintWriter writer = response.getWriter();
		writer.println("HTTP Status 401 - " + authEx.getMessage());
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		setRealmName("Basic Auth");
		super.afterPropertiesSet();
	}
}