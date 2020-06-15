package com.sxdx.proxy;

import com.sxdx.entity.MyLog;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @program: spring
 * @description:
 * @author: garnett
 * @create: 2020-04-23 17:34
 **/

public class UserCglibProxy implements MethodInterceptor {

	private MyLog myLog;

	private Enhancer enhancer = new Enhancer();

	// 这里的目标类型为Object，则可以接受任意一种参数作为被代理类
	public Object getInstance(Class clazz, MyLog myLog) {
		this.myLog = myLog;
		enhancer.setSuperclass(clazz);
		enhancer.setCallback(this);
		// 返回代理对象
		return enhancer.create();
	}



	@Override
	public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
		myLog.before();
		Object result = methodProxy.invokeSuper(o, objects);
		myLog.after();
		return result;
	}

	public MyLog getMyLog() {
		return myLog;
	}

	public void setMyLog(MyLog myLog) {
		this.myLog = myLog;
	}
}