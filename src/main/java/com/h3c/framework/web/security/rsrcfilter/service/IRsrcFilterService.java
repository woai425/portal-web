package com.h3c.framework.web.security.rsrcfilter.service;

import java.util.List;
import java.util.Map;

import com.h3c.framework.H3cException;
import com.h3c.framework.common.entities.Sysfunction;
import com.h3c.framework.core.annotation.NotProguard;


/**
 * *********************************************************************
 * 功能模块根据用户角色进行过滤接口
 * IRsrcFilterService.java
 *
 * H3C所有，
 * 受到法律的保护，任何公司或个人，未经授权不得擅自拷贝。
 * @copyright   Copyright: 2015-2020
 * @creator     z10926<br/>
 * @create-time 2016年2月5日 下午5:11:07
 * @revision    $Id:  *
 **********************************************************************
 */
@NotProguard
public interface IRsrcFilterService {
	
	final String RSRC_CONT_BTN_FLAG = "1";//权限中包括按钮

	/**
	 * 根据登录名获取登录模块权限
	 * @param condition
	 * @return
	 * @throws H3cException
	 */
	public List<Sysfunction> getNavInfoByLoginname(String ... condition) throws H3cException;
	

	/**
	 * 根据登录名获取拥有的按钮功能
	 * @param loginname
	 * @return
	 * @throws H3cException
	 */
	public Map<String,Integer> getFilterdBtnsByLoginname(String loginname) throws H3cException;
	
	/**
	 * 根据用户名和ID获取人员信息
	 * @param loginname
	 * @return
	 * @throws H3cException
	 */
	public Map<String,String>  getPersonInfoByUserId(String loginname,String userId) throws H3cException;
}
