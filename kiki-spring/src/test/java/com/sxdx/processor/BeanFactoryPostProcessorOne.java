package com.sxdx.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.core.Ordered;

/**
 * @program: spring
 * @description: BeanFactoryPostProcessor
 * @author: garnett
 * @create: 2020-04-16 14:00
 **/

//@Component
public class BeanFactoryPostProcessorOne implements BeanFactoryPostProcessor ,Ordered{
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		System.out.println("BeanFactoryPostProcessorOne");
		BeanDefinition dog = beanFactory.getBeanDefinition("processor");
		if (dog != null){
			MutablePropertyValues mv = dog.getPropertyValues();
			mv.add("name","拉布拉多").add("age",22);
		}
	}

	@Override
	public int getOrder() {
		return 1;
	}
}
