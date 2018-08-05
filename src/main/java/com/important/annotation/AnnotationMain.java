package com.important.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.important.annotation.controller.UserController;
import com.important.annotation.repository.UserRepository;
import com.important.annotation.service.UserService;

public class AnnotationMain {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans-annotation.xml");

		TestObject to = (TestObject) ac.getBean("testObject");
		System.out.println(to);
		
		UserController userController = (UserController) ac.getBean("userController");
		System.out.println(userController);
		
		UserService userService = (UserService) ac.getBean("userService");
		System.out.println(userService);
		
		UserRepository userRepositoryImpl = (UserRepository) ac.getBean("userRepository");
		System.out.println(userRepositoryImpl);
	}

}
