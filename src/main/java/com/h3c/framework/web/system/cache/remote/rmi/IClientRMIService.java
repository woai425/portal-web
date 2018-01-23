package com.h3c.framework.web.system.cache.remote.rmi;

import java.util.Collection;
import com.h3c.framework.common.dto.ClientDTO;



/**
 * *********************************************************************
 * 用户信息缓存接口
 * IClientRMIService.java
 *
 * H3C所有，
 * 受到法律的保护，任何公司或个人，未经授权不得擅自拷贝。
 * @copyright   Copyright: 2015-2020
 * @creator     z10926<br/>
 * @create-time 2016年4月28日 下午7:54:32
 * @revision    $Id:  *
 **********************************************************************
 */
public interface IClientRMIService {

	/**
	 * 
	 * @param sessionId
	 * @param ClientDTO
	 */
	public void addClinet(String sessionId, ClientDTO ClientDTO);
	
	/**
	 * 
	 * @param sessionId
	 */
	public void removeClinet(String sessionId);
	
	/**
	 * 
	 * @param loginname
	 * @param username
	 */
	public void removeClinet(String loginname, String username);
	
	/**
	 * 
	 * @param sessionId
	 * @return
	 */
	public ClientDTO getClient(String sessionId);
	
	/**
	 * 
	 * @param loginname
	 * @param username
	 * @return
	 */
	public ClientDTO getClient(String loginname, String username);
	
	/**
	 * 获取所有用户
	 * @return
	 */
	public Collection<ClientDTO> getAllClient();
}
