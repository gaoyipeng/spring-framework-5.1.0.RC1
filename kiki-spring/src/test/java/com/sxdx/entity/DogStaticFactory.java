package com.sxdx.entity;

/**
 * @program: spring
 * @description: 静态工厂方法
 * @author: garnett
 * @create: 2020-04-08 15:34
 **/

public class DogStaticFactory {

	public DogStaticFactory() {
		System.out.println("静态工厂实例化");
	}

	//静态工厂方法
	public static Dog getInstances(){
		return new Dog();
	}
}
