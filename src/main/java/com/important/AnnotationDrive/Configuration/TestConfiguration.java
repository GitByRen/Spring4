package com.important.AnnotationDrive.Configuration;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.important.AnnotationDrive.Config.MainConfig;

public class TestConfiguration {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
		Person bean = applicationContext.getBean(Person.class);
		System.out.println(bean);

		// 获取Person类的bean
//		String[] beanNamesForType = applicationContext.getBeanNamesForType(Person.class);
//		for (String name : beanNamesForType) {
//			System.out.println(name);
//		}
		
		// 获取IOC中的bean
		String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
		for (String value : beanDefinitionNames) {
			System.out.println(value);
		}
	}

}
