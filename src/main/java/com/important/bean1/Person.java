package com.important.bean1;

import java.util.List;
import java.util.Map;

public class Person {

	private String name;
	private int age;
	private Car car;
	private List<Car> listCar;
	private Map<String, Car> mapCar;
	
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

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}
	
	public List<Car> getListCar() {
		return listCar;
	}

	public void setListCar(List<Car> listCar) {
		this.listCar = listCar;
	}

	public Map<String, Car> getMapCar() {
		return mapCar;
	}

	public void setMapCar(Map<String, Car> mapCar) {
		this.mapCar = mapCar;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", car=" + car + ", listCar=" + listCar + ", mapCar=" + mapCar
				+ "]";
	}

	public Person(String name, int age, Car car) {
		super();
		this.name = name;
		this.age = age;
		this.car = car;
	}

	public Person() {
		super();
	}

}
