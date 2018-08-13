package com.important.AnnotationDrive.Configuration;

import java.util.Map;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.important.AnnotationDrive.Config.MainConfig;
import com.important.AnnotationDrive.Config.MainConfig2;

public class TestConfiguration {

	/**
	 * @Conditional
	 */
	@Test
	public void test3() {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
		printAppByType(applicationContext, Person.class);
		Map<String, Person> persons = applicationContext.getBeansOfType(Person.class);
		System.out.println(persons);
	}
	
	/**
	 * @Scope,@Lazy
	 */
	@Test
	public void test2() {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
		Person bean = applicationContext.getBean(Person.class);
		Person bean1 = applicationContext.getBean(Person.class);
		System.out.println(bean == bean1);
	}

	/**
	 * @bean,@ComponentScan,TypeFilter
	 */
	@Test
	public void test1() {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
		Person bean = applicationContext.getBean(Person.class);
		System.out.println(bean);

		// 获取Person类的bean
		printAppByType(applicationContext, Person.class);

		// 获取IOC中的bean
		printAppByName(applicationContext);
	}
	
	public void printAppByType(ApplicationContext ac, Class<?> clazz) {
		String[] beanNamesForType = ac.getBeanNamesForType(clazz);
		for (String name : beanNamesForType) {
			System.out.println(name);
		}
	}
	
	public void printAppByName(ApplicationContext ac) {
		String[] beanDefinitionNames = ac.getBeanDefinitionNames();
		for (String value : beanDefinitionNames) {
			System.out.println(value);
		}
	}
}
