package com.h3c.framework.core.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义启用事物注解
 * @author 周兆巍
 * @version 创建时间：2014年12月4日 下午4:22:28
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface H3cTransaction {
	public boolean value() default true;
}
