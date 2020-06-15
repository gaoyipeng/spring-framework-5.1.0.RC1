package com.sxdx.aspect;

import com.sxdx.entity.User;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @program: spring
 * @description:
 * @author: garnett
 * @create: 2020-04-24 17:11
 **/

public class UserAspect {

	/**
	 * 前置增强
	 */
	public void beforeAdvice(User user) {
		System.out.println("==前置增强，id：" + user.getId() + "，name：" + user.getName());
	}

	/**
	 * 后置异常增强
	 */
	public void afterExceptionAdvice(User user) {
		System.out.println("==后置异常增强，id：" + user.getId() + "，name：" + user.getName());
	}

	/**
	 * 后置返回增强
	 */
	public void afterReturningAdvice(User user) {
		System.out.println("==后置返回增强，id：" + user.getId() + "，name：" + user.getName());
	}

	/**
	 * 后置最终增强
	 */
	public void afterAdvice(User user) {
		System.out.println("==后置最终增强，id：" + user.getId() + "，name：" + user.getName());
	}

	/**
	 * 环绕增强
	 * 注意: 如果环绕增强里通过try catch对异常做了处理,所以当业务方法抛出异常时,后置异常增强不会被执行.
	 */
	public Object roundAdvice(ProceedingJoinPoint p, User user) throws Throwable {
		System.out.println("==环绕增强开始，id：" + user.getId() + "，name：" + user.getName());
		Object o = null;
         o = p.proceed();
		System.out.println("==环绕增强结束，id：" + user.getId() + "，name：" + user.getName());
		return o;
	}

}
