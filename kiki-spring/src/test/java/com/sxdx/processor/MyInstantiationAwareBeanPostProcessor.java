package com.sxdx.processor;

import com.sxdx.entity.Processor;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @program: spring
 * @description: InstantiationAwareBeanPostProcessorAdapter
 * @author: garnett
 * @create: 2020-04-17 14:25
 **/

//@Component
public class MyInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {

	/**
	 * BeanPostProcessor接口中的方法
	 * 在Bean的自定义初始化方法之前执行
	 * Bean对象已经存在了
	 */
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
/*		if (beanName.equals("processor")){
			((Processor)bean).setAge(100);
			((Processor)bean).setName("特朗普");
		}*/
		// TODO Auto-generated method stub
		System.out.println(">>postProcessBeforeInitialization"+"-----"+beanName);
		return bean;
	}

	/**
	 * InstantiationAwareBeanPostProcessor中自定义的方法
	 * 在方法实例化之前执行  Bean对象还没有创建
	 */
	@Nullable
	public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
		System.out.println("--->postProcessBeforeInstantiation"+"-----"+beanName);

		// 利用cglib动态代理生成对象返回
		/*if (beanClass == Processor.class) {
			Enhancer e = new Enhancer();
			e.setSuperclass(beanClass);
			e.setCallback(new MethodInterceptor() {
				@Override
				public Object intercept(Object obj, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

					System.out.println("目标方法执行前:" + method + "\n");
					Object object = methodProxy.invokeSuper(obj, objects);
					System.out.println("目标方法执行后:" + method + "\n");
					return object;
				}
			});
			Processor processor = (Processor) e.create();
			// 返回代理类
			return processor;
		}*/
		return null;
	}

	/**
	 * BeanPostProcessor接口中的方法
	 * 在Bean的自定义初始化方法执行完成之后执行
	 * Bean对象已经存在了
	 */
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("<<postProcessAfterInitialization"+"-----"+beanName);
		return bean;
	}



	/**
	 * InstantiationAwareBeanPostProcessor中自定义的方法
	 * 在方法实例化之后执行  Bean对象已经创建出来了
	 */
	public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
		System.out.println("<---postProcessAfterInstantiation"+"-----"+beanName);
		return true;
	}

	/**
	 * InstantiationAwareBeanPostProcessor中自定义的方法
	 * 可以用来修改Bean中属性的内容
	 */
	@Nullable
	public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName)
			throws BeansException {
		System.out.println("<---postProcessPropertyValues--->"+"-----"+beanName);
		if(bean instanceof Processor){
			((Processor) bean).setName("Garnett");
		}
		return pvs;
	}

}
