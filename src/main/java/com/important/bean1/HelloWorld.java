package com.important.bean1;

public class HelloWorld {

	private String name;

	public HelloWorld() {
		System.out.println("HelloWorld constructor...");
	}

	public void setName(String name) {
		System.out.println("setName" + name);
		this.name = name;
	}

	public void sayHello() {
		System.out.println("Hello:" + name);
	}

}
