package com.sxdx.proxy;

import org.springframework.stereotype.Service;

/**
 * @program: spring
 * @description: 实现类
 * @author: garnett
 * @create: 2020-04-18 16:42
 **/
@Service
public class CountImpl implements Count {
	@Override
	public void queryCount() {
		System.out.println("查询账户");
	}

	@Override
	public void updateCount() {
		System.out.println("修改账户");
	}
}
