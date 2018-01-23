package com.h3c.framework.core.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * *********************************************************************
 * 表单重复提交token
 * H3cToken.java
 * 
 * H3C所有，
 * 受到法律的保护，任何公司或个人，未经授权不得擅自拷贝。
 * @copyright   Copyright: 2015-2020
 * @creator     z10926<br/>
 * @create-time 2016年1月8日 下午7:31:19
 * @revision    $Id:  *
 **********************************************************************
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface H3cToken {
	public boolean value() default true;
}
