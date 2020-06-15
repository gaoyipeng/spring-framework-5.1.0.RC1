package com.sxdx.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.core.Ordered;

/**
 * @program: spring
 * @description: BeanFactoryPostProcessor
 * @author: garnett
 * @create: 2020-04-16 14:01
 **/

//@Component
public class BeanFactoryPostProcessorTwo implements BeanFactoryPostProcessor , Ordered {
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		System.out.println("BeanFactoryPostProcessorTwo");

	}
	@Override
	public int getOrder() {
		return 2;
	}
}
