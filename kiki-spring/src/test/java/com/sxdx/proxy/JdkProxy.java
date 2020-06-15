package com.sxdx.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @program: spring
 * @description:
 * @author: garnett
 * @create: 2020-04-18 17:26
 **/

public class JdkProxy implements InvocationHandler {

	// 目标对象
	private Object target;

	/**
	 * 构造方法
	 * @param target 目标对象
	 */
	public JdkProxy(Object target) {
		super();
		this.target = target;
	}

	/**
	 * 获取目标对象的代理对象
	 * @return 代理对象
	 */
	public Object getProxy() {
		/**
		 * 参数：
		 * 1、获取当前线程的类加载
		 * 2、获取接口（要求代理类必须有接口实现）
		 * 3、当前对象
		 */
		return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
				target.getClass().getInterfaces(),
				this);
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("==代理方法开始执行");
		Object invoke = method.invoke(target, args);
		System.out.println("==代理方法结束执行");
		return invoke;
	}
}
