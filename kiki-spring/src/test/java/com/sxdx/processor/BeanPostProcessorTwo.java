package com.sxdx.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;

/**
 * @program: spring
 * @description: BeanPostProcessor
 * @author: garnett
 * @create: 2020-04-16 14:01
 **/


//@Component
public class BeanPostProcessorTwo implements BeanPostProcessor , Ordered {

	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("BeanPostProcessorTwo");
		return bean;
	}


	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		return bean;
	}

	@Override
	public int getOrder() {
		return 1;
	}
}
