package com.gec;

public class TestDemo {
	static String name;
	int age;
	int demo;
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public static String getName() {
		return name;
	}
	public static void setName(String name) {
		TestDemo.name = name;
	}

	public static void main(String[] args) {
		System.out.println("Hello world!");
	}
}
