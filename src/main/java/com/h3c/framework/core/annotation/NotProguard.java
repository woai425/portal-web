package com.h3c.framework.core.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * *********************************************************************
 *
 * NotProguard.java
 *
 * H3C所有，
 * 受到法律的保护，任何公司或个人，未经授权不得擅自拷贝。
 * @copyright   Copyright: 2015-2020
 * @creator     z10926<br/>
 * @create-time 2016年8月24日 下午4:20:41
 * @revision    $Id:  *
 **********************************************************************
 */
@Retention(RetentionPolicy.CLASS)  
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.FIELD}) 
public @interface NotProguard {

}
