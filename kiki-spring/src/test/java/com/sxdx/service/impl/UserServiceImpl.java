package com.sxdx.service.impl;

import com.sxdx.entity.User;
import com.sxdx.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @program: spring
 * @description:
 * @author: garnett
 * @create: 2020-04-23 17:08
 **/

@Service
public class UserServiceImpl implements UserService {
	@Override
	public void addUser(User user) {
		System.out.println("添加 user"+user.getName());
	}

	@Override
	public void deleteUser(User user) {
		System.out.println("删除 user"+user.getName());
		System.out.println("==抛出异常：" + 1 / 0);
	}
}
