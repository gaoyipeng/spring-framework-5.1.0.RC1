package com.sxdx.entity;

import com.sxdx.proxy.CountProxy;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @program: spring
 * @description: cc
 * @author: garnett
 * @create: 2020-04-16 16:59
 **/

public class Processor implements BeanNameAware , BeanFactoryAware, ApplicationContextAware,InitializingBean, DisposableBean {
	private String name;
	private int age;

	public Processor() {
		System.out.println("Processor 实例化");
	}

	public Processor(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public void initMethod(){
		System.out.println("初始化方法");
	}

	public void destroyMethod(){
		System.out.println("destroy-method方法被调动了");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Processor{" +
				"name='" + name + '\'' +
				", age=" + age +
				'}';
	}

	public void sayGood(){
		System.out.println("大家好, 我叫" + getName() + ", 我今年" + getAge() + "岁了");
	}

	@Override
	public void setBeanName(String name) {
		System.out.println("BeanNameAware返回BeanName："+name);
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		beanFactory.getBean("countProxy",CountProxy.class).queryCount();
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

		applicationContext.getBean("countProxy",CountProxy.class).queryCount();
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("afterPropertiesSet初始化");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("destroy 销毁");
	}
}
