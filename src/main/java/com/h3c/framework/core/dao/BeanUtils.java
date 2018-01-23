/***********************************************************************
*
* BeanUtils.java
*
* H3C所有，
* 受到法律的保护，任何公司或个人，未经授权不得擅自拷贝。
* @copyright   Copyright: 2015-2020
* @creator     c10709<br/>
* @create-time 2016年11月11日 下午2:45:41
* @revision    $Id:  *
***********************************************************************/
package com.h3c.framework.core.dao;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author l11656
 * 普通类获取spring中bean的工具类
 */
@Component
public class BeanUtils implements ApplicationContextAware {

	private static ApplicationContext applicationContext = null;
	
	/* (non-Javadoc)
	 * @see org.springframework.context.ApplicationContextAware#setApplicationContext(org.springframework.context.ApplicationContext)
	 */
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		if(BeanUtils.applicationContext == null){
			BeanUtils.applicationContext  = applicationContext;
	       }
	}
	
	/**
	 * 获取applicationContext
	 * @return
	 */
    public static ApplicationContext getApplicationContext() {
       return applicationContext;
    }

    /**
     *  通过name获取 Bean.
     * @param name
     * @return
     */
    public static Object getBean(String name){
       return getApplicationContext().getBean(name);
    }
    
    
    /**
     * 通过class获取Bean.
     * @param clazz
     * @return
     */
    public static <T> T getBean(Class<T> clazz){
       return getApplicationContext().getBean(clazz);
    }
   
    /**
     * 通过name,以及Clazz返回指定的Bean
     * @param name
     * @param clazz
     * @return
     */
    public static <T> T getBean(String name,Class<T> clazz){
       return getApplicationContext().getBean(name, clazz);
    }
}
