package com.h3c.framework.core.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.h3c.framework.H3cException;

/**
 * 操作日志切面
 * @author 周兆巍
 * @version 创建时间：2014年12月3日 上午11:46:59
 */
@Component
@Aspect
@Order(2)
public class H3cTransAspect {
	
    private static final Logger logger = Logger.getLogger(H3cTransAspect.class);
	@Pointcut("@annotation(com.h3c.framework.core.annotation.H3cTransaction)")
	public void transPointcut() {
		
	}
	
	@Around("transPointcut()")
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public Object aroundTransPointcut(ProceedingJoinPoint joinPoint) throws H3cException{
		Object result = null;
		String methodName = joinPoint.getSignature().getName();
		try {
			//前置通知
			logger.info("事务前置通知：" + "The method " + methodName + " begins with ....");
			//执行目标方法
			result = joinPoint.proceed();
			//返回通知
			logger.info("事务返回通知：" + "The method " + methodName + " ends with " + result);
		} catch (Throwable e) {
			//异常通知
			logger.info("事务异常通知：" + "The method " + methodName + " occurs exception:" + e);
			throw new RuntimeException(e);
		}
		return result;
	}
}
