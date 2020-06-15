package com.sxdx.aspect;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @program: spring
 * @description: advisor
 * @author: garnett
 * @create: 2020-05-10 17:10
 **/

public class UserAspectAdvisor implements MethodBeforeAdvice , AfterReturningAdvice {
	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		System.out.println("==前置增强，方法名为" + method.getName());
	}

	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		System.out.println("==后置增强，方法名为" + method.getName());
	}
}
