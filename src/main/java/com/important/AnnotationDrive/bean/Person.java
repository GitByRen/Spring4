package com.important.AnnotationDrive.bean;

import org.springframework.beans.factory.annotation.Value;

public class Person {

	@Value("张三")
	private String name;
	// SPEL
	@Value("#{18-2}")
	private Integer age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

	public Person(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
	}

	public Person() {
		super();
	}

}
