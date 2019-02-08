package com.important.factoryBean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FactoryBeanMain {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-beanfactory.xml");
		Car car = (Car) ctx.getBean("car");
		Car car1 = (Car) ctx.getBean("car");
		// 测试FactoryBean的isSingleton
		System.out.println(car == car1);
	}
	
}
