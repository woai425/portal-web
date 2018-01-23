package com.h3c.framework.core.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 方法是否需要保存日志
 * @author 周兆巍
 * @version 创建时间：2014年12月3日 上午11:42:18
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface OpLog {
	/**
	 * 日志类型,PICTURE图片日志,RECORD数据日志,DEFAULT纯事物
	 * @return
	 */
	public abstract H3cLogType value() default H3cLogType.DEFAULT;
	
	/**
	 * 日志摘要信息
	 * @return
	 */
	public abstract String digest() default "";
	
	/**
	 * 模块名
	 * @return
	 */
	public abstract String moduleName() default "";
		
}

