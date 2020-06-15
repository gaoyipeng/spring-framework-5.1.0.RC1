package com.sxdx.entity;

import org.springframework.stereotype.Component;

/**
 * @program: spring
 * @description:
 * @author: garnett
 * @create: 2020-04-23 18:00
 **/

public class MyLog {
	//日志记录开始
	public void before(){
		System.out.println("日志记录开始");
	}
	//提交事务
	public void after(){
		System.out.println("日志记录结束");
	}
}
