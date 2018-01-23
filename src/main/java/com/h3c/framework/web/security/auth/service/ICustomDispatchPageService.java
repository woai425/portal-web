package com.h3c.framework.web.security.auth.service;

import com.h3c.framework.H3cException;
import com.h3c.framework.core.annotation.NotProguard;

/**
 * *********************************************************************
 * 客户端自定义跳转页面接口，获取客户端设置的首页面 <br/>
 * ICustomDispatcherPage.java <br/>
 *
 * H3C所有，<br/>
 * 受到法律的保护，任何公司或个人，未经授权不得擅自拷贝。<br/>
 *
 * @copyright Copyright: 2015-2020
 * @creator z10926 <br/>
 * @create-time 2016年11月17日 上午9:50:46
 * @revision $Id: *
 **********************************************************************
 */
@NotProguard
public interface ICustomDispatchPageService {

	/**
	 * 获取客户端返回的自定义首页面
	 * 
	 * @param userId
	 * @param loginname
	 * @return
	 * @throws H3cException
	 */
	public String getCustomDispatchPage(String userId, String loginname) throws H3cException;
}
