package com.important.AnnotationDrive.Configuration;

import java.util.Map;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.important.AnnotationDrive.Config.MainConfig;
import com.important.AnnotationDrive.Config.MainConfig2;
import com.important.AnnotationDrive.bean.Person;

public class TestConfiguration {

	@Test
	public void test4() {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
		printAppByName(applicationContext);
		System.out.println("******************");
		// 工厂Bean获取的是调用getObject创建的对象
		Object bean = applicationContext.getBean("colorFactoryBean");
		System.out.println(bean.getClass());
		
		// 获取工厂Bean本身
		Object factoryBean = applicationContext.getBean("&colorFactoryBean");
		System.out.println(factoryBean.getClass());
		
	}
	
	/**
	 * @Conditional
	 * 
	 * -Dos.name=linux
	 */
	@Test
	public void test3() {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
		Map<String, Person> persons = applicationContext.getBeansOfType(Person.class);
		System.out.println(persons);
	}
	
	/**
	 * @Scope,@Lazy
	 */
	@Test
	public void test2() {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
		Person bean = (Person) applicationContext.getBean("person");
		Person bean1 = (Person) applicationContext.getBean("person");
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

		// 获取IOC中的bean
		printAppByName(applicationContext);
	}
	
	public void printAppByName(ApplicationContext ac) {
		String[] beanDefinitionNames = ac.getBeanDefinitionNames();
		for (String value : beanDefinitionNames) {
			System.out.println(value);
		}
	}
}
