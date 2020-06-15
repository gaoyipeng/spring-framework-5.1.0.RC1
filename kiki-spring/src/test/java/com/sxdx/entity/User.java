package com.sxdx.entity;

/**
 * @program: spring
 * @description: user
 * @author: garnett
 * @create: 2020-04-23 17:06
 **/

public class User {
	private int id;
	private String name;

	public User(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
