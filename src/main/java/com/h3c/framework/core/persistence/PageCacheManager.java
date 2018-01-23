package com.h3c.framework.core.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.SQLQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.h3c.framework.H3cException;
import com.h3c.framework.core.dao.H3cSession;

/**
 * ********************************************************************* 
 * 页面缓存持久类
 * PageCacheManager.java
 *
 * H3C所有， 受到法律的保护，任何公司或个人，未经授权不得擅自拷贝。
 * 
 * @copyright Copyright: 2015-2020
 * @creator z10926<br/>
 * @create-time 2014年10月29日 下午5:50:13
 * @revision $Id: *
 **********************************************************************
 */
@Component("pageCacheManager")
public class PageCacheManager {
	
	@Autowired
	private H3cSession session;

	private PageCacheManager() {}

	private volatile Map<String, String> cache = new HashMap<String, String>();

	public synchronized void initPageCache() throws H3cException {
		cache.clear();
		Map<String, String> map = getSysfuntionNeedCache();
		if (map != null) {
			cache.putAll(map);
		}
	}

	public synchronized void addPageCache(String funtionid, String uri) {
		cache.put(funtionid, uri);
	}

	public synchronized void removePageCache(String funtionid) {
		cache.remove(funtionid);
	}

	public Boolean isCached(String uri) {
		return cache.containsValue(uri);
	}

	/**
	 * 获取需要缓存的模块信息
	 * @return
	 * @throws H3cException
	 */
	private Map<String, String> getSysfuntionNeedCache() throws H3cException {
		SQLQuery query = session.createSQLQuery("select functionid,location from Sysfunction where cache='1'");
		@SuppressWarnings("unchecked")
		List<Object[]> lst = query.list();
		Map<String, String> map = null;
		if (lst.size() > 0) {
			map = new HashMap<String, String>();
			for (Object[] obj : lst) {
				map.put(obj[0].toString(), obj[1].toString());
			}
		}
		return map;
	}
}
