package com.h3c.framework.core.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import com.h3c.framework.H3cException;

/**
 * 
 * spring容器BEAN获取
 * @author 周兆巍
 * @version 创建时间：2014年10月29日 下午8:15:00
 */

public final class HBUtil {
	
	private HBUtil(){
		throw new Error("请不要实例化 HBUtil");
	}

//	private static class SingletonHolder{
//		 public final static HBUtil instance = new HBUtil();   
//	}
//	
//	public static HBUtil getInstance(){
//		return SingletonHolder.instance;
//	}
//	
	public static H3cSession getH3cSession(){
		//WebApplicationContext ctx = ContextLoader.getCurrentWebApplicationContext();
		return (H3cSession)BeanUtils.getBean("h3cSession");
	}
	
	public static Session openNewSession(){
		return getH3cSession().openNewSession();
	}	
	
	/**
	 * 取序列发生器的下一个值
	 * @param sequenceName
	 * @return
	 * @throws Exception
	 */
	public static String getSequence(String sequenceName) throws H3cException{
		H3cSession session = getH3cSession();
		Query query = session.createSQLQuery("Select " + sequenceName + ".nextval from dual");
		return query.uniqueResult().toString();
	}

}
