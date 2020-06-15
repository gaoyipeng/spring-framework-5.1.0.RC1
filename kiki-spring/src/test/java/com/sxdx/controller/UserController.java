package com.sxdx.controller;

import com.sxdx.entity.MyLog;
import com.sxdx.entity.User;
import com.sxdx.proxy.UserCglibProxy;
import com.sxdx.service.UserService;
import com.sxdx.service.impl.UserServiceImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @program: spring
 * @description:
 * @author: garnett
 * @create: 2020-04-23 17:18
 **/

public class UserController {
	private ApplicationContext applicationContext;



	@Before
	public void initXmlBeanFactory() {
		System.out.println("\n========测试方法开始=======\n");
		applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
	}

	@After
	public void after() {
		((ClassPathXmlApplicationContext) applicationContext).close();
		System.out.println("\n========测试方法结束=======\n");
	}

	@Test
	public void test() throws Exception {
		User user = new User(1,"二狗子");
		MyLog myLog = new MyLog();
		/*UserService userService = applicationContext.getBean("userServiceImpl", UserServiceImpl.class);
		userService.addUser(user);
		userService.deleteUser(user);*/

		//动态代理了UserServiceImpl, myLog负责日志记录
		UserService userService = (UserService) new UserCglibProxy().getInstance(UserServiceImpl.class,myLog);
		userService.addUser(user);
	}

	@Test
	public void test1() throws Exception {
		UserService userService = applicationContext.getBean("userServiceImpl", UserServiceImpl.class);
		User user = new User(1,"二狗子");
		MyLog myLog = new MyLog();
		myLog.before();
		userService.addUser(user);
		myLog.after();
	}

	@Test
	public void test2() throws Exception {
		UserService userService = applicationContext.getBean("userServiceImpl", UserServiceImpl.class);
		User user = new User(1,"二狗子");
		userService.addUser(user);
	}

	@Test
	public void test3() throws Exception {
		UserService userService = (UserService) applicationContext.getBean("userServiceImpl");
		User user = new User(1,"二狗子");
		userService.addUser(user);
	}


}
