package com.sxdx.entity;

import org.springframework.beans.factory.FactoryBean;

/**
 * @program: spring
 * @description: FactoryBean
 * @author: garnett
 * @create: 2020-04-11 15:52
 **/

public class DogFactoryBean implements FactoryBean<Dog> {
	@Override
	public Dog getObject() throws Exception {
		return null;
	}

	@Override
	public Class<?> getObjectType() {
		return null;
	}

	@Override
	public boolean isSingleton() {
		return false;
	}
}
