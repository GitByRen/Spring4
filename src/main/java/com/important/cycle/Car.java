package com.important.cycle;

public class Car {

	public Car() {
		System.out.println("Car's Constructor...");
	}

	private String brand;

	public void setBrand(String brand) {
		System.out.println("setBrand...");
		this.brand = brand;
	}

	private void init() {
		System.out.println("init...");
	}

	private void destroy() {
		System.out.println("destroy...");
	}

	@Override
	public String toString() {
		return "Car [brand=" + brand + "]";
	}

}
