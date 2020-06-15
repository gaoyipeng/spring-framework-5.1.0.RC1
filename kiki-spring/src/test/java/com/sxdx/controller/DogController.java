package com.sxdx.controller;

import com.sxdx.entity.Dog;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @program: spring
 * @description: dog
 * @author: garnett
 * @create: 2020-04-07 10:33
 **/

public class DogController {

	private ApplicationContext applicationContext;

	@Before
	public void initXmlBeanFactory() {
		System.out.println("\n========测试方法开始=======\n");
		applicationContext = new ClassPathXmlApplicationContext("dog-bean.xml");
	}

	@After
	public void after() {
		System.out.println("\n========测试方法结束=======\n");
	}


	@Test
	public void test1() {
		// 默认构造器
		Dog dog1 = applicationContext.getBean("dog1", Dog.class);
		Dog dog2 = applicationContext.getBean("dog1", Dog.class);

		System.out.println(dog1 == dog2);


		//Dog dog2 = applicationContext.getBean("dog2", Dog.class);
		//dog1.sayHello();
		//dog2.sayHello();
	}

	@Test
	public void test2() {
		Dog dog3 = applicationContext.getBean("dog3", Dog.class);
		dog3.sayHello();
	}

	@Test
	public void test3() {
		Dog dog4 = applicationContext.getBean("dog4", Dog.class);
		dog4.sayHello();
	}

	/*@Test
	public void test4() {
		Dog dog1 = applicationContext.getBean("dog3", Dog.class);
		Dog dog2 = applicationContext.getBean("dog3", Dog.class);
		//Food food = applicationContext.getBean("food", Food.class);
		System.out.println("Dog : singleton类型，所以 dog1 == dog2 为"+ (dog1 == dog2)); //结果为true,则符合预期


		Food food1 = dog1.getFood();
		Food food2 = dog2.getFood();
		System.out.println("Dog : singleton类型,Food : prototype 类型。未使用lookup-method注入所以 food1 == food2 结果为true,则符合预期:"+ (food1 == food2));


		Food food3 = dog1.createFood();
		Food food4 = dog2.createFood();
		System.out.println("Dog : singleton类型,Food : prototype 类型。使用了lookup-method注入，所以 food3 == food4 结果为false,则符合预期:"+ (food3 == food4));

	}*/

	@Test
	public void test4() {
		Dog dog1 = applicationContext.getBean("dog5", Dog.class);
		dog1.sayGoodBye();
		dog1.sayGoodBye("fff");
	}

	@Test
	public void test5() throws Throwable{

	}


}