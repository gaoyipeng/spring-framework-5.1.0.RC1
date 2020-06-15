package com.sxdx.proxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @program: spring
 * @description: 代理类
 * @author: garnett
 * @create: 2020-04-18 16:43
 **/

//@Component
public class CountProxy implements Count{

	@Autowired
	@Qualifier("countImpl")
	private Count countImpl;

	@Override
	public void queryCount() {
		countImpl.queryCount();
	}

	@Override
	public void updateCount() {
		countImpl.updateCount();
	}
}
