package com.h3c.framework.util;

import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.hibernate.Query;
import org.hibernate.Session;

import com.h3c.framework.common.entities.Sysparam;
import com.h3c.framework.core.annotation.NotProguard;
import com.h3c.framework.core.dao.HBUtil;

/**
 * *********************************************************************
 * 系统全局配置信息 <br/>
 * GlobalNames.java <br/>
 *
 * H3C所有，<br/>
 * 受到法律的保护，任何公司或个人，未经授权不得擅自拷贝。<br/>
 *
 * @copyright Copyright: 2015-2020
 * @creator z10926 <br/>
 * @create-time 2014年11月3日 下午12:39:38
 * @revision $Id: *
 **********************************************************************
 */
@NotProguard
public final class GlobalNames {

	// ----日志------
	public static final Logger log = Logger.getLogger(GlobalNames.class);

	public static final int LOG_TYPE_LOGIN = 1; // 登陆
	
	public static final int LOG_TYPE_EXIT = 2; // 退出
	
	public static final int LOG_TYPE_BIZ = 3; // 业务

	/**
	 * 系统参数列表，/WEB-INF/conf/SysConfig.xml中的参数全部缓存在该列表中， 以及动态读入的系统参数也加载进来
	 */
	public static final ConcurrentMap<String, String> sysConfig = new ConcurrentHashMap<String, String>();

	/**
	 * 读取配制文件，同时形成配制信息 这个在系统启动时加载
	 * 
	 * @param inputstream
	 */
	@SuppressWarnings("unchecked")
	public static final void readConfiguration(InputStream inputstream) {
		SAXReader saxReader = new SAXReader();
		try {
			Document document = saxReader.read(inputstream);
			Element eles=document.getRootElement();
			for(Iterator<Element> i = eles.elementIterator(); i.hasNext();){
			     Element ele = i.next();
			     sysConfig.put(ele.attribute("name").getValue(), ele.attribute("value").getValue());
			     log.info("系统参数 ："+ele.attribute("name").getValue() + " = " + ele.attribute("value").getValue());
			}
		} catch (Exception e) {
			log.info("配置系统综合参数异常：" + e.getMessage());
			return ;
		}
	}

	/**
	 * 读取系统综合参数，同时形成配制信息
	 * 
	 * @param inputstream
	 */
	@SuppressWarnings("unchecked")
	public static final synchronized void readConfiguration() {
		// System.out.println("读取系统综合参数.....");
		Session session = HBUtil.openNewSession();
		try {
			// H3cSession session = HBUtil.getH3cSession();
			Query query = session.createQuery("from Sysparam a");
			List<Sysparam> lst = query.list();
			for (Sysparam param : lst) {
				System.out.println("配置 " + param.getParamcode() + ": "
						+ param.getParamvalue());
				sysConfig.put(param.getParamcode(), param.getParamvalue());
			}
		} catch (Exception e) {
			log.info("配置系统综合参数异常：" + e.getMessage());
			e.printStackTrace();
		} finally {
			session.close(); // 释放资源
		}
		// System.out.println("读取系统综合参数，配置综合参数成功！");
	}
}
