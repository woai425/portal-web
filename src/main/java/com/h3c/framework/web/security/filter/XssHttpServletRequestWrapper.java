package com.h3c.framework.web.security.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.apache.commons.lang3.StringEscapeUtils;
/**
 * *********************************************************************
 * 处理XSS攻击的请求包装类,将<>&"回车换行进行转译
 * <=&lt;  >=&gt; &=&amp; "="&quot;
 * XssHttpServletRequestWrapper.java
 * 
 * H3C所有，
 * 受到法律的保护，任何公司或个人，未经授权不得擅自拷贝。
 * @copyright   Copyright: 2015-2020
 * @creator     z10926<br/>
 * @create-time 2016年7月20日 上午9:40:25
 * @revision    $Id:  *
 **********************************************************************
 */
public class XssHttpServletRequestWrapper extends HttpServletRequestWrapper {

	public XssHttpServletRequestWrapper(HttpServletRequest request) {
		super(request);
	}


    @Override
	public String getHeader(String name) {  
        return StringEscapeUtils.escapeHtml4(super.getHeader(name));  
    }  
  

    @Override
	public String getQueryString() {  
        return StringEscapeUtils.escapeHtml4(super.getQueryString());  
    }  
  

    @Override
	public String getParameter(String name) {  
        return StringEscapeUtils.escapeHtml4(super.getParameter(name));  
    }  
  

    @Override
	public String[] getParameterValues(String name) {  
        String[] values = super.getParameterValues(name);  
        if(values != null) {  
            int length = values.length;  
            String[] escapseValues = new String[length];  
            for(int i = 0; i < length; i++){  
				if ("userlog".equals(name)) {
					escapseValues[i] = values[i];
					continue;
				}
				// 允许json格式无须校验，为了提升校验速度，不采用强转失败后捕获异常后处理的方式
				if ((((values[i].startsWith("[{\"") || values[i].startsWith("{\"")) && (values[i].endsWith("\"}]"))) || values[i]
						.endsWith("\"}"))) {
					escapseValues[i] = values[i];
					continue;
				}
                escapseValues[i] = StringEscapeUtils.escapeHtml4(values[i]);  

            }  
            return escapseValues;  
        }  
        return super.getParameterValues(name);  
    }  
}
