package com.sxdx.entity;

import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;

/**
 * @program: spring
 * @description: replace-method
 * @author: garnett
 * @create: 2020-04-09 17:27
 **/

public class ReplaceDog implements MethodReplacer {
	@Override
	public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
		System.out.println("替换内容");
		//Arrays.stream(args).forEach(str -> System.out.println("参数:" + str));
		return obj;
	}
}
