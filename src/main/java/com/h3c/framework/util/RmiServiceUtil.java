package com.h3c.framework.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.h3c.framework.web.system.cache.remote.rmi.IClientRMIService;


/**
 * *********************************************************************
 * 远程方法调用服务辅助类
 * RmiServiceUtil.java
 *
 * H3C所有，
 * 受到法律的保护，任何公司或个人，未经授权不得擅自拷贝。
 * @copyright   Copyright: 2015-2020
 * @creator     z10926<br/>
 * @create-time 2016年4月29日 上午11:47:48
 * @revision    $Id:  *
 **********************************************************************
 */
public class RmiServiceUtil {

	private static IClientRMIService clientService;
	
	static {
		@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:conf/spring-mvc-rmi-cache.xml");
		clientService = (IClientRMIService) ctx.getBean("myClient");
	}
	
	public static IClientRMIService getClientRmiService(){
		return clientService;
	} 
	
}
