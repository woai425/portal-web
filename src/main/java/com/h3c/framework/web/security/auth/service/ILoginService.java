package com.h3c.framework.web.security.auth.service;

import com.h3c.framework.H3cException;
import com.h3c.framework.common.entities.Sysuser;
import com.h3c.framework.core.annotation.NotProguard;
import com.h3c.framework.exception.UserException;

/**
 * *********************************************************************
 * 登录验证接口
 * ILoginService.java
 *
 * H3C所有，
 * 受到法律的保护，任何公司或个人，未经授权不得擅自拷贝。
 * @copyright   Copyright: 2015-2020
 * @creator     z10926<br/>
 * @create-time 2014年12月1日 上午9:06:51
 * @revision    $Id:  *
 **********************************************************************
 */
@NotProguard
public interface ILoginService {

	/**
	 * 校验用户是否存在
	 * 
	 * @param loginname
	 * @param passwd
	 * @return
	 * @throws UserException
	 */
	public boolean checkUserIsExistsOrNot(String loginname, String passwd)
			throws UserException;

	/**
	 * 获取用户信息
	 * 
	 * @param loginname
	 * @param passwd
	 * @return
	 * @throws UserException
	 */
	public Sysuser getUserByLogin(String loginname, String passwd)
			throws UserException;

	/**
	 * 根据用户名获取用户信息
	 * 
	 * @param loginname
	 * @param passwd
	 * @return
	 * @throws UserException
	 */
	public Sysuser getUserByLoginName(String loginname) throws UserException;

	/**
	 * 添加用户登录日志
	 * @param logContent
	 * @param logTpye
	 * @throws UserException
	 */
	public void addLog(String loginname, String logContent, int logTpye) throws UserException;
	
	/**
	 * 检查用户名是否存在
	 * @param loginName
	 * @return
	 */
	public boolean checkNameIsExistsOrNot(String loginName);

	/**
	 * 检查密码有效性
	 * @param loginName
	 * @return
	 */
	public Boolean checkValidTime(String loginName);

	/**
	 * 锁定用户
	 * @param loginName
	 * @throws UserException
	 */
	public void lockUser(String loginName) throws UserException;

	/**
	 * 检查用户是否被锁定
	 * @param loginname
	 * @return
	 */
	public boolean checkUserIsLocksOrNot(String loginname);

	/**
	 * 获取跳转页面
	 * 
	 * @return
	 * @throws H3cException
	 */
	public String getDispatchPage() throws H3cException;
}
