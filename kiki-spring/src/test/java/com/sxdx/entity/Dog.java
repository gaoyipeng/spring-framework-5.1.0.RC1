package com.sxdx.entity;

/**
 * @program: spring
 * @description: dog
 * @author: garnett
 * @create: 2020-04-07 10:29
 **/

public class Dog {
	private String name;

	private int age;

	private Food food;

	//默认构造器
	public Dog() {
		System.out.println("默认构造器 init");
	}
	//带参构造器
	public Dog(String name, int age) {
		System.out.println("带参构造器 init");
		this.name = name;
		this.age = age;
	}

	public Dog(String name, int age, Food food) {
		this.name = name;
		this.age = age;
		this.food = food;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Food getFood() {
		return food;
	}

	public void setFood(Food food) {
		this.food = food;
	}

	public void sayHello() {
		System.out.println("大家好, 我叫" + getName() + ", 我今年" + getAge() + "岁了"+"，喜欢吃"+ food.getName());
	}
	public void sayGoodBye() {
		System.out.println("大家好, 我叫" + getName() + ", 我今年" + getAge() + "岁了"+"，GoodBye");
	}
	public void sayGoodBye(String con) {
		System.out.println("大家好, 我叫" + getName() + ", 我今年" + getAge() + "岁了"+"，GoodBye");
	}

}
