package com.important.bean1;

public class Car {

	private String name;
	private String local;
	private double price;
	private int age;

	public Car(String name, String local, double price) {
		super();
		this.name = name;
		this.local = local;
		this.price = price;
	}

	public Car(String name, String local, int age) {
		super();
		this.name = name;
		this.local = local;
		this.age = age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Car [name=" + name + ", local=" + local + ", price=" + price + ", age=" + age + "]";
	}

}
