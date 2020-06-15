package com.sxdx.aspect;

import com.sxdx.entity.User;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @program: spring
 * @description:
 * @author: garnett
 * @create: 2020-04-24 17:11
 **/

@Aspect
@Component
public class UserAspectAnno {



	/**
	 * 前置增强
	 */
	@Before("execution(* com.sxdx.service.impl.UserServiceImpl.*(..)) and args(user)")
	public void beforeAdvice(User user) {
		System.out.println("==前置增强，id：" + user.getId() + "，name：" + user.getName());
	}

	/**
	 * 后置异常增强
	 */
	@AfterThrowing("execution(* com.sxdx.service.impl.UserServiceImpl.*(..)) and args(user)")
	public void afterExceptionAdvice(User user) {
		System.out.println("==后置异常增强，id：" + user.getId() + "，name：" + user.getName());
	}

	/**
	 * 后置返回增强
	 */
	@AfterReturning("execution(* com.sxdx.service.impl.UserServiceImpl.*(..)) and args(user)")
	public void afterReturningAdvice(User user) {
		System.out.println("==后置返回增强，id：" + user.getId() + "，name：" + user.getName());
	}

	/**
	 * 后置最终增强
	 */
	@After("execution(* com.sxdx.service.impl.UserServiceImpl.*(..)) and args(user)")
	public void afterAdvice(User user) {
		System.out.println("==后置最终增强，id：" + user.getId() + "，name：" + user.getName());
	}

	/**
	 * 环绕增强
	 * 注意: 如果环绕增强里通过try catch对异常做了处理,所以当业务方法抛出异常时,后置异常增强不会被执行.
	 */
	@Around("execution(* com.sxdx.service.impl.UserServiceImpl.*(..)) and args(user)")
	public Object roundAdvice(ProceedingJoinPoint p, User user) throws Throwable {
		System.out.println("==环绕增强开始，id：" + user.getId() + "，name：" + user.getName());
		Object o = null;
         o = p.proceed();
		System.out.println("==环绕增强结束，id：" + user.getId() + "，name：" + user.getName());
		return o;
	}

}
