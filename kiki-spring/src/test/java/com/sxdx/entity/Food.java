package com.sxdx.entity;

/**
 * @program: spring
 * @description: 食物
 * @author: garnett
 * @create: 2020-04-09 09:36
 **/


public class Food {
	private String name ;

	public Food() {

	}

	public Food(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
