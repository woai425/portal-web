package com.h3c.framework.core.oplog;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.h3c.framework.H3cException;
import com.h3c.framework.common.entities.Sysuserlog;
import com.h3c.framework.core.dao.H3cSession;
import com.h3c.framework.util.BrowserUtils;
import com.h3c.framework.util.ContextHolderUtils;
import com.h3c.framework.util.DateUtil;
import com.h3c.framework.util.ResourceUtil;

/**
 * *********************************************************************
 * 操作日志管理
 * OpLogManager.java
 *
 * H3C所有，
 * 受到法律的保护，任何公司或个人，未经授权不得擅自拷贝。
 * @copyright   Copyright: 2015-2020
 * @creator     z10926<br/>
 * @create-time 2014年12月3日 下午2:08:36
 * @revision    $Id:  *
 **********************************************************************
 */
@Component
public class OpLogManager{
	
	@Autowired
	private H3cSession session;

	/**
	 * 保存PICTURE操作日志
	 * @param strUserlog
	 * @throws H3cException
	 */
	@SuppressWarnings("unchecked")
	public void saveOpLog(String strUserlog) throws H3cException{	
		
        if(strUserlog==null){
        	throw new H3cException("操作日志摘要为空，或者模块未配置记录日志，请确认！");
        }
        Map<String,String> jsonobject = null;
		ObjectMapper mapper = new ObjectMapper();
		try {
			jsonobject = mapper.readValue(strUserlog, Map.class);
		} catch (IOException e) {
			throw new H3cException(e.getMessage());
		}
		Sysuserlog userlog=new Sysuserlog();
		//userlog.setOpseno(UUIDHexUtil.generate32bit());
		userlog.setFunctionid(jsonobject.get("functionid"));
		userlog.setObjectid(jsonobject.get("objectid"));
		userlog.setDigest(jsonobject.get("digest"));
		userlog.setPrcol1(jsonobject.get("prcol1"));
		userlog.setPrcol2(jsonobject.get("prcol2"));
		userlog.setPrcol3(jsonobject.get("prcol3"));
		userlog.setPrcol4(jsonobject.get("prcol4"));
		userlog.setPrcol5(jsonobject.get("prcol5"));
		userlog.setPrcol6(jsonobject.get("prcol6"));
		userlog.setPrcol7(jsonobject.get("prcol7"));
		userlog.setPrcol8(jsonobject.get("prcol8"));

		byte[] b = StringZipHelper.zipString(jsonobject.get("orisource").trim());
		userlog.setOrisourceb(b);

		Date d = new Date();
		userlog.setOptime(d);
		//业务年月暂时设为当前年月
		userlog.setYm(DateUtil.getYM(d));
		userlog.setOperator(ResourceUtil.getSessionUser().getUser().getLoginname());
		//userlog.setAreano("000000");
		userlog.setBzstate("0");
		userlog.setLogtype(3);
		userlog.setOpip(ResourceUtil.getIp());
		String broswer = BrowserUtils.checkBrowse(((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest());
		userlog.setBroswer(broswer);
		session.save(userlog);
		
	}
	
	@Deprecated
	public String getOriSource(Blob oriSourceB){
		if(oriSourceB==null){
			return null;
		}
		ByteArrayOutputStream os=null;
		InputStream is=null;
		try{
			os = new ByteArrayOutputStream();
		 	is = oriSourceB.getBinaryStream();
		 	byte[] buffer = new byte[1024];
		 	int len = 0;
		 	while((len = is.read(buffer) )!= -1){
		 		os.write(buffer,0,len);
		 	}
		 	String s= null;
		 	return s;
		}catch(Exception e){
			if(os!=null){try{ os.close();}catch(Exception e1){}}
			if(is!=null){try{ is.close();}catch(Exception e1){}}
			return null;
		}
	}
	

	/**
	 * 保存数据日志
	 * @param digest
	 * @param moduleName
	 * @throws H3cException
	 */
	public void saveBizLog(String digest,String moduleName) throws H3cException{	
		HttpServletRequest request = ContextHolderUtils.getRequest();
		String broswer = BrowserUtils.checkBrowse(request);
		Sysuserlog log = new Sysuserlog();
		log.setDigest(digest);
		log.setPrcol1(moduleName);
		log.setLogtype(3);
		log.setBzstate("0");
		log.setOpip(ResourceUtil.getIp());
		log.setBroswer(broswer);
		Date d = new Date();
		log.setYm(DateUtil.getYM(d));
		log.setOperator(ResourceUtil.getSessionUser().getUser().getLoginname());
		log.setOptime(d);
        session.save(log);
	}
}
