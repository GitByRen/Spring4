package com.important.factory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FactoryMain {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans-factory.xml");
		Car car1 = (Car) ac.getBean("car1");
		System.out.println(car1);
		
		Car car2 = (Car) ac.getBean("car2");
		System.out.println(car2);
	}
	
}
