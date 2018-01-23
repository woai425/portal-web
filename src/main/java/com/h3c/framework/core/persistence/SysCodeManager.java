package com.h3c.framework.core.persistence;

import java.util.Map;
import java.util.TreeMap;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.h3c.framework.H3cException;
import com.h3c.framework.web.system.code.service.ISysCode;

/**
 * 数据字典持久类
 * 
 * @author 周兆巍
 * @version 创建时间：2014年10月29日 下午5:50:13
 */
@Component("SysCodeManager")
public class SysCodeManager {
	private volatile Map<String, Map<String, String>> ddMap = null;

	@Resource(name = "DefaultSysCode")
	private ISysCode syscode;

	private SysCodeManager() {
	}

	/**
	 * 获取数据字典
	 * 
	 * @return
	 * @throws H3cException
	 */
	public Map<String, Map<String, String>> getDdMap() {
		return ddMap;
	}
	
	/**
	 * @Title initDdMap
	 * @Description 设置数据字典集合
	 * @param ddMap
	 * @throws H3cException
	 */
	public void initDdMap() throws H3cException {
		if (ddMap == null) {
			synchronized (this) {
				if (ddMap == null) {
					ddMap = syscode.getAllCodeMap();
				}
			}
		}
	}

	public synchronized void updateDdMap(String code, String oldCodeValue, String newCodeValue, String newCodeExplain) {
		Map<String, String> map = this.ddMap.get(code);
		map.remove(oldCodeValue);
		map.put(newCodeValue, newCodeExplain);
	}

	public synchronized void deleteDdMap(String code, String codeValue) {
		Map<String, String> map = this.ddMap.get(code);
		map.remove(codeValue);
	}

	public synchronized void insertDdMap(String code, String codeValue, String codeExplain) {
		Map<String, String> map = this.ddMap.get(code);
		if (map == null) {
			map = new TreeMap<String, String>();
			ddMap.put(code, map);
		}
		map.put(codeValue, codeExplain);
	}

}
