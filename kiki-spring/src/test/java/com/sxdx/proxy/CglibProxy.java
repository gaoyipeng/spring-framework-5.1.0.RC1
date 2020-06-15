package com.sxdx.proxy;


import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @program: spring
 * @description:
 * @author: garnett
 * @create: 2020-04-18 19:40
 **/

public class CglibProxy implements MethodInterceptor {

	private Enhancer enhancer = new Enhancer();

	// 这里的目标类型为Object，则可以接受任意一种参数作为被代理类
	public Object getInstance(Class clazz) {
		enhancer.setSuperclass(clazz);
		enhancer.setCallback(this);
		// 返回代理对象
		return enhancer.create();
	}


	@Override
	public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
		System.out.println("Cglib代理方法开始执行");
		Object result = methodProxy.invokeSuper(o, objects);
		System.out.println("Cglib代理方法结束执行");
		return result;

	}
}
