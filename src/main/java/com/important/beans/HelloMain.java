package com.important.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloMain {

	public static void main(String[] args) {
		/*
		 * ApplicationContext代表IOC容器.
		 * ClassPathXmlApplicationContext是ApplicationContext接口的实现类， 该实现类从类路径下来加载配置文件
		 */
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		HelloWorld hello = (HelloWorld) ctx.getBean("helloWorld");
		
		// 利用类型返回IOC容器中的Bean,但要求IOC容器中只能有一个该类型的Bean
//		HelloWorld hello = ctx.getBean(HelloWorld.class);
		hello.sayHello();
		
		System.out.println("********构造器注入********");
		
		Car car1 = (Car) ctx.getBean("car");
		System.out.println(car1);
		Car car2 = (Car) ctx.getBean("car1");
		System.out.println(car2);
		
		System.out.println("********Bean的引用及Bean级联*********");
		
		Person person = (Person) ctx.getBean("person");
		System.out.println(person);
		Person person1 = (Person) ctx.getBean("person1");
		System.out.println(person1);
		
	}
	
}
