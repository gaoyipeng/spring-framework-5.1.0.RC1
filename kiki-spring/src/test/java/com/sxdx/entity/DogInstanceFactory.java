package com.sxdx.entity;

/**
 * @program: spring
 * @description: 实例工厂方法
 * @author: garnett
 * @create: 2020-04-08 15:46
 **/

public class DogInstanceFactory {
	public DogInstanceFactory() {
		System.out.println("实例工厂方法实例化");
	}

	//静态工厂方法
	public Dog getInstances(){
		return new Dog("德牧",5);
	}
}
