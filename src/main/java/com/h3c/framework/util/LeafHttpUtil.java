package com.h3c.framework.util;

import javax.servlet.http.HttpServletRequest;

/**
 * *********************************************************************
 * LeafHttpUtil.java
 *
 * H3C所有，
 * 受到法律的保护，任何公司或个人，未经授权不得擅自拷贝。
 * @copyright   Copyright: 2015-2020
 * @creator     z10926<br/>
 * @create-time 2016年3月1日 下午1:30:22
 * @revision    $Id:  *
 **********************************************************************
 */
public class LeafHttpUtil {
	public static String calcReqFunction(
			HttpServletRequest paramHttpServletRequest) {
		String str1 = paramHttpServletRequest.getParameter("method");
		String str2 = paramHttpServletRequest.getServletPath();
		StringBuffer localStringBuffer = new StringBuffer(str2);
		if (str1 == null) {
			String str3 = paramHttpServletRequest.getParameter("prefix");
			String str4 = paramHttpServletRequest.getParameter("page");
			if ((str3 != null) && (str4 != null))
				localStringBuffer.append("?prefix=").append(str3)
						.append("&page=").append(str4);
		} else {
			localStringBuffer.append("?method=").append(str1);
		}
		String str3 = paramHttpServletRequest.getParameter("menuId");
		if (str3 != null)
			localStringBuffer.append("&menuId=").append(str3);
		if (localStringBuffer.indexOf("?") < 0) {
			int i = localStringBuffer.indexOf("&");
			if (i >= 0)
				localStringBuffer.replace(i, i + 1, "?");
		}
		String str5 = localStringBuffer.toString();
		return str5;
	}

	public static String getRequestResource(
			HttpServletRequest paramHttpServletRequest) {
		StringBuffer localStringBuffer = new StringBuffer();
		localStringBuffer.append(paramHttpServletRequest.getServletPath());
		String str = paramHttpServletRequest.getQueryString();
		if (str != null)
			localStringBuffer.append("?").append(str);
		return localStringBuffer.toString();
	}
}
