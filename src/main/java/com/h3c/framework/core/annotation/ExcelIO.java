package com.h3c.framework.core.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * EXCEL导入导出切入点
 * @author 周兆巍
 * @version 创建时间：2014年12月25日 下午7:59:56
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ExcelIO {
	public abstract String value();
}
