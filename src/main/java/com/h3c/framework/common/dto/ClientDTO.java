package com.h3c.framework.common.dto;

import java.util.Map;
import java.util.Set;

import com.h3c.framework.common.entities.Sysfunction;
import com.h3c.framework.common.entities.Sysuser;


/**
 * 在线用户对象
 * @author 周兆巍
 * @version 创建时间：2014年11月30日 下午8:20:44
 */
public class ClientDTO implements java.io.Serializable {

	private static final long serialVersionUID = 3071063172137138079L;

	private Sysuser user;

	private Map<String, Sysfunction> functions;
	
	/**
	 * 用户功能模块路径的集合
	 */
	private Set<String> funcLocations;


	/**
	 * 用户IP
	 */
	private java.lang.String ip;
	/**
	 *登录时间
	 */
	private java.util.Date logindatetime;

	public Sysuser getUser() {
		return user;
	}

	public void setUser(Sysuser user) {
		this.user = user;
	}


	public Map<String, Sysfunction> getFunctions() {
		return functions;
	}

	public void setFunctions(Map<String, Sysfunction> functions) {
		this.functions = functions;
	}

	public java.lang.String getIp() {
		return ip;
	}

	public void setIp(java.lang.String ip) {
		this.ip = ip;
	}

	public java.util.Date getLogindatetime() {
		return logindatetime;
	}

	public void setLogindatetime(java.util.Date logindatetime) {
		this.logindatetime = logindatetime;
	}
	
	
	public Set<String> getFuncLocations() {
		return funcLocations;
	}

	public void setFuncLocations(Set<String> funcLocations) {
		this.funcLocations = funcLocations;
	}
}
