package com.sxdx.controller;

import com.sxdx.entity.Processor;
import com.sxdx.proxy.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import sun.misc.ProxyGenerator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @program: spring
 * @description: dd
 * @author: garnett
 * @create: 2020-04-12 09:28
 **/

public class Test1 {

	private ApplicationContext applicationContext;


	@Before
	public void initXmlBeanFactory() {
		System.out.println("\n========测试方法开始=======\n");
		applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
	}

	@After
	public void after() {
		((ClassPathXmlApplicationContext) applicationContext).close();
		System.out.println("\n========测试方法结束=======\n");
	}

	@Test
	public void test() throws Exception {
		Processor processor = applicationContext.getBean("processor",Processor.class);
		System.out.println(processor.toString());
	}

	@Test
	public void test1() throws Exception {
		CountProxy countProxy = applicationContext.getBean("countProxy",CountProxy.class);
		countProxy.queryCount();
		countProxy.updateCount();
	}

	@Test
	public void test2() throws Exception {
		JdkProxy handler = new JdkProxy(new CountImpl());
		Count proxy = (Count) handler.getProxy();
		proxy.queryCount();

		//输出生成的代理类
		String name = "$Proxy";
		byte[] data =
				ProxyGenerator.generateProxyClass(name,new Class[]{Count.class});
		FileOutputStream out =null;
		try {
			out = new FileOutputStream(name+".class");
			System.out.println((new File("hello")).getAbsolutePath());
			out.write(data);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(null!=out) try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	@Test
	public void test3() throws Exception {
		CountImpl count = (CountImpl) new CglibProxy().getInstance(CountImpl.class);
		count.queryCount();
	}
}
