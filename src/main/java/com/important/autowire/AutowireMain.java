package com.important.autowire;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AutowireMain {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans-autowire.xml");
		Person p = (Person) ac.getBean("person");
		System.out.println(p);
	}
	
}
