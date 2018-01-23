package com.h3c.framework.core.interceptor;

import java.util.Date;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.h3c.framework.core.persistence.SysfunctionManager;
import com.h3c.framework.util.GlobalNames;
import com.h3c.framework.util.LeafHttpUtil;

/**
 * *********************************************************************
 * portal框架的安全拦截器
 * SafetyInterceptor.java
 * 
 * H3C所有，
 * 受到法律的保护，任何公司或个人，未经授权不得擅自拷贝。
 * @copyright   Copyright: 2015-2020
 * @creator     z10926<br/>
 * @create-time 2016年2月22日 上午9:55:30
 * @revision    $Id:  *
 **********************************************************************
 */
public class BusinessInterceptor implements HandlerInterceptor {

	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		String reqFunction = LeafHttpUtil.calcReqFunction(request);	
		Enumeration<String>	enums = request.getParameterNames();
		String url = null;
		boolean sessOpFlag = false;
		while(enums.hasMoreElements()){
			String param = enums.nextElement();
			if(param.indexOf("open")>-1){
				url = param;
			}else{
				if(url!=null){
					url = url +"&"+param;
				}
			}
			if("1".equals(GlobalNames.sysConfig.get("SESSN_TMOUT_CNTL"))){
				if(param.equals("checkIsLoginOrNot")||param.equals("checkSessnIsTmoutOrNot")||param.equals("monitorQuery")){
					sessOpFlag = true;
				}
			}
		}
		if(url!=null){
			SysfunctionManager.setCurrentRequestFunctionCache(reqFunction.replace("/", "")+"?"+url);
		}
		//在拦截器里增加最后访问时间的控制，则可以根据此时间进行判断是否已经超时
	    if("1".equals(GlobalNames.sysConfig.get("SESSN_TMOUT_CNTL"))){
			if(sessOpFlag==false){
				request.getSession().setAttribute("SESSNTMOUT", new Date().getTime()+request.getSession().getMaxInactiveInterval()*1000);
			}	
	    }  
		return true;
	}

	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
	}

	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
	}
	
	
}
