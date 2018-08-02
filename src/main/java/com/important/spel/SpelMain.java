package com.important.spel;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpelMain {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans-spel.xml");
		Address add = (Address) ac.getBean("address");
		System.out.println(add);
		
		Car car = (Car) ac.getBean("car");
		System.out.println(car);
		
		Person person = (Person) ac.getBean("person");
		System.out.println(person);
	}
	
}
