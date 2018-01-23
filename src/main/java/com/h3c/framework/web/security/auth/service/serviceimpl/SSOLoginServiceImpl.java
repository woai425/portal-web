package com.h3c.framework.web.security.auth.service.serviceimpl;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.h3c.framework.H3cException;
import com.h3c.framework.common.dto.ClientDTO;
import com.h3c.framework.common.entities.Sysfunction;
import com.h3c.framework.core.support.ServiceSupport;
import com.h3c.framework.util.GlobalNames;
import com.h3c.framework.util.UUIDHexUtil;
import com.h3c.framework.web.security.auth.service.ISSOLoginService;
import com.h3c.framework.web.security.rsrcfilter.service.IRsrcFilterService;

/**
 * *********************************************************************
 * 单点登录接口实现类，作用是对外提供单点登录到Portal的功能<br/>
 * SSOLoginServiceImpl.java <br/>
 *
 * H3C所有，<br/>
 * 受到法律的保护，任何公司或个人，未经授权不得擅自拷贝。<br/>
 * 
 * @copyright Copyright: 2015-2020
 * @creator z10926 <br/>
 * @create-time 2016年10月28日 下午3:17:51
 * @revision $Id: *
 **********************************************************************
 */
@Service
public class SSOLoginServiceImpl extends ServiceSupport implements ISSOLoginService {

	private final Map<String, String> tokenForSSO = new ConcurrentHashMap<>();

	@Autowired
	private IRsrcFilterService rsrcFilterService;

	@Override
	public String getToken(String loginName) throws H3cException {
		String token = UUIDHexUtil.generate32bit();// 动态生成，设置有效时间
		tokenForSSO.put(loginName, token);
		return token;
	}

	@Override
	public Boolean checkToken(String loginName, String token) throws H3cException {
		if (StringUtils.isEmpty(loginName) || StringUtils.isEmpty(token)) {
			return false;
		}
		if(token.equals(tokenForSSO.get(loginName))){
			return true;
		}
		return false;
	}

	@Override
	public Boolean isSuperUser(String loginName) throws H3cException {
		String superUsers = GlobalNames.sysConfig.get("PORTAL_SUPER_USERS");
		String[] usrs = superUsers.split(",");
		for (int i = 0; i < usrs.length; i++) {
			if (loginName.equals(usrs[i])) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void setUserFunctionByLoginName(String loginName, ClientDTO dto) throws H3cException {
		List<Sysfunction> sysfunctionList = null;
		try {
			sysfunctionList = rsrcFilterService.getNavInfoByLoginname(loginName, IRsrcFilterService.RSRC_CONT_BTN_FLAG);
		} catch (H3cException e) {
			throw new H3cException(e.getMessage());
		}

		Set<String> sysfunctionSet = new HashSet<String>();
		if ((sysfunctionList != null) && (sysfunctionList.size() > 0)) {
			for (Sysfunction sysfunction : sysfunctionList) {
				sysfunctionSet.add(sysfunction.getLocation());
			}
		}
		dto.setFuncLocations(sysfunctionSet);
	}

	@Override
	public String getLocationByUrlParam(String urlParam) throws H3cException {
		Query query = session.createQuery("from Sysfunction a where a.location like :location");
		query.setString("location", "%" + urlParam + "%");
		Sysfunction function = (Sysfunction) query.uniqueResult();
		if (function != null) {
			return function.getLocation();
		}
		return null;
	}

}
