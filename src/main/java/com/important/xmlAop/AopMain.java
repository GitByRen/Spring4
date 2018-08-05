package com.important.xmlAop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopMain {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-aopxml.xml");
		ArithmeticCalculator arithmeticCalculator = (ArithmeticCalculator) ctx.getBean("arithmeticCalculator");
		
		int add = arithmeticCalculator.add(2, 4);
		System.out.println(add);
		
		int div = arithmeticCalculator.div(2, 1);
		System.out.println(div);
	}
	
}
