package com.sxdx.processor;

import com.sxdx.entity.Processor;
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
public class BeanPostProcessorOne implements BeanPostProcessor , Ordered {

	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("BeanPostProcessorOne");
		if (beanName.equals("processor")){
			((Processor)bean).setAge(100);
		}
		return bean;
	}


	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		return bean;
	}

	@Override
	public int getOrder() {
		return 2;
	}
}
