package com.important.cycle;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CycleMain {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("beans-cycle.xml");
		Car car = (Car) ac.getBean("car");
		ac.close();
	}

}
