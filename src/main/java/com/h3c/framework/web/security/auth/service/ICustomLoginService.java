package com.h3c.framework.web.security.auth.service;

import javax.servlet.http.HttpServletRequest;

import com.h3c.framework.H3cException;
import com.h3c.framework.common.dto.AjaxJson;
import com.h3c.framework.core.annotation.NotProguard;

/**
 * *********************************************************************
 * ICustomLoginService.java 
 * 客户端自定义登录校验接口类 
 * H3C所有， 受到法律的保护，任何公司或个人，未经授权不得擅自拷贝。
 * @copyright Copyright: 2015-2020
 * @creator z10926<br/>
 * @create-time 2016年1月23日 上午11:10:35
 * @revision $Id: *
 **********************************************************************
 */
@NotProguard
public interface ICustomLoginService {

	/**
	 * 客户端自定义系统登录校验
	 * @param loginname
	 * @param password
	 * @param req
	 * @return
	 * @throws H3cException
	 */
	public AjaxJson customLogin(String loginname, String password, HttpServletRequest req) throws H3cException;

}
