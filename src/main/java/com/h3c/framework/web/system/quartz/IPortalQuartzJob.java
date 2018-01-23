package com.h3c.framework.web.system.quartz;

/**
 * *********************************************************************
 * portal框架的调度器初始化接口
 * IPortalQuartzJob.java
 *
 * H3C所有，
 * 受到法律的保护，任何公司或个人，未经授权不得擅自拷贝。
 * @copyright   Copyright: 2015-2020
 * @creator     z10926<br/>
 * @create-time 2016年2月5日 上午11:16:58
 * @revision    $Id:  *
 **********************************************************************
 */
public interface IPortalQuartzJob {

	/**
	 * 调度器初始化接口
	 */
	public void initQuartzJob();
}
