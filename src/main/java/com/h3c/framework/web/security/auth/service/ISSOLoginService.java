package com.h3c.framework.web.security.auth.service;

import com.h3c.framework.H3cException;
import com.h3c.framework.common.dto.ClientDTO;
import com.h3c.framework.core.annotation.NotProguard;

/**
 * *********************************************************************
 * 单点登录接口服务类，作用是对外提供单点登录到Portal的功能<br/>
 * ISSOLoginService.java <br/>
 *
 * H3C所有，<br/>
 * 受到法律的保护，任何公司或个人，未经授权不得擅自拷贝。<br/>
 * @copyright Copyright: 2015-2020
 * @creator z10926 <br/>
 * @create-time 2016年10月28日 下午3:16:01
 * @revision $Id: *
 **********************************************************************
 */
public interface ISSOLoginService {

	/**
	 * 根据登录名获取Token值
	 * 
	 * @param loginName
	 * @return
	 * @throws H3cException
	 */
	@NotProguard
	public String getToken(String loginName) throws H3cException;

	/**
	 * 校验传入的TOKEN是否有效
	 * @param loginName
	 * @param token
	 * @return
	 * @throws H3cException
	 */
	public Boolean checkToken(String loginName, String token) throws H3cException;

	/**
	 * 判断登录人员是否为超级管理员
	 * 
	 * @param loginName
	 * @return
	 * @throws H3cException
	 */
	public Boolean isSuperUser(String loginName) throws H3cException;

	/**
	 * 根据用户名添加用户的功能列表
	 * 
	 * @param loginName
	 * @param dto
	 * @throws H3cException
	 */
	public void setUserFunctionByLoginName(String loginName, ClientDTO dto) throws H3cException;

	/**
	 * 根据URL上的参数获取系统功能表对应的URL路径
	 * 
	 * @param urlParam
	 * @return
	 * @throws H3cException
	 */
	public String getLocationByUrlParam(String urlParam) throws H3cException;
}
