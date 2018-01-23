package com.h3c.framework.core.persistence;

import java.util.Map;
import java.util.List;

/**
 * 数据字典缓存
 * @author 周兆巍
 * @version 创建时间：2014年10月29日 下午5:51:33
 */
public class CodeDataCache {

	//var rpflag_comboData = [['0','普通模块'],['1','普通报表']]
    private List<Map<String,String>> hpLst;
    
    private Map<String,Map<String,String>> ddMap = null;//数据字典新储存方式

	public List<Map<String, String>> getHpLst() {
		return hpLst;
	}

	public void setHpLst(List<Map<String, String>> hpLst) {
		this.hpLst = hpLst;
	}
	
	public Map<String, Map<String, String>> getDdMap() {
		return ddMap;
	}

	public void setDdMap(Map<String, Map<String, String>> ddMap) {
		this.ddMap = ddMap;
	}
	
}
