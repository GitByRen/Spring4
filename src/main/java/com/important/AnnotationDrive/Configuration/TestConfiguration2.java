package com.important.AnnotationDrive.Configuration;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.important.AnnotationDrive.Config.MainConfigOfLifeCycle;
import com.important.AnnotationDrive.Config.MainConfigOfPropertyValue;
import com.important.AnnotationDrive.bean.Person;

public class TestConfiguration2 {

	/**
	 * bean的生命周期
	 */
	@Test
	public void test1() {
		// 创建ioc容器
		AnnotationConfigApplicationContext annotationConfig = new AnnotationConfigApplicationContext(MainConfigOfLifeCycle.class);
//		annotationConfig.getBean("car");
		annotationConfig.close();
	}

	/**
	 * @Value
	 */
	@Test
	public void test2() {
		AnnotationConfigApplicationContext annotationConfig = new AnnotationConfigApplicationContext(MainConfigOfPropertyValue.class);
		Person person = (Person) annotationConfig.getBean("person");
		System.out.println(person);
	}
}
