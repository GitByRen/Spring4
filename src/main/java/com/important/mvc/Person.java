package com.important.mvc;

public class Person {

	private String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void hello() {
		System.out.println("hello " + username);
	}
}
