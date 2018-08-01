package com.important.relation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.important.autowire.Address;
import com.important.autowire.Person;

public class RelationMain {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans-relation.xml");
		Address a = (Address) ac.getBean("address");
		System.out.println(a);
		
		System.out.println("****测试继承***");
		Address a2 = (Address) ac.getBean("address2");
		System.out.println(a2);
		
		System.out.println("****测试抽象bean****");
		Address a4 = (Address) ac.getBean("address4");
		System.out.println(a4);
		
		System.out.println("****测试依赖*****");
		Person p = (Person) ac.getBean("person");
		System.out.println(p);
	}
	
}
