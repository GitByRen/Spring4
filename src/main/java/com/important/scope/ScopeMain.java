package com.important.scope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.important.autowire.Car;

public class ScopeMain {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans-scope.xml");
		Car a = (Car) ac.getBean("car");
		Car b = (Car) ac.getBean("car");
		System.out.println(a == b);
	}
	
}
