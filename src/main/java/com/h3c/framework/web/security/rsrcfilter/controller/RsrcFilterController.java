package com.h3c.framework.web.security.rsrcfilter.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.h3c.framework.H3cException;
import com.h3c.framework.common.dto.AjaxJson;
import com.h3c.framework.core.support.ControllerSupport;
import com.h3c.framework.util.GlobalNames;
import com.h3c.framework.util.ResourceUtil;
import com.h3c.framework.web.security.rsrcfilter.service.IRsrcFilterService;

/**
 * *********************************************************************
 * 功能模块根据用户角色进行过滤接口控制类
 * RsrcFilterController.java
 *
 * H3C所有，
 * 受到法律的保护，任何公司或个人，未经授权不得擅自拷贝。
 * @copyright   Copyright: 2015-2020
 * @creator     z10926<br/>
 * @create-time 2016年2月5日 下午5:51:33
 * @revision    $Id:  *
 **********************************************************************
 */
@Controller
@RequestMapping(value = "/rsrcFilterController")
public class RsrcFilterController extends ControllerSupport<Object>{

	@Autowired
	private IRsrcFilterService service;
	
	@RequestMapping(params = "filterRsrc")
	@ResponseBody
	public AjaxJson filterRsrc(HttpSession session) throws H3cException {
		AjaxJson json = new AjaxJson();
		String loginname = ResourceUtil.getSessionUser().getUser().getLoginname();
		json.setData(service.getNavInfoByLoginname(loginname));
		
		//非超级管理员增加按钮权限的后台过滤
		String superUsers = GlobalNames.sysConfig.get("PORTAL_SUPER_USERS"); 
		String [] usrs = superUsers.split(",");
		Boolean superFlag = false;
		for(int i=0;i<usrs.length;i++){
			if(loginname.equals(usrs[i])){
				superFlag = true;
				break;
			}
		}
		if (!superFlag) {
		    session.setAttribute("psRoleFunction", service.getFilterdBtnsByLoginname(loginname));
		}
		return json;
	}

	
}
