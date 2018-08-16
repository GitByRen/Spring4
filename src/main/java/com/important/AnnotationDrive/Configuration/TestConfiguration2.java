package com.important.AnnotationDrive.Configuration;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.important.AnnotationDrive.Annotation.TestService;
import com.important.AnnotationDrive.Config.MainConfigOfAutowire;
import com.important.AnnotationDrive.Config.MainConfigOfLifeCycle;
import com.important.AnnotationDrive.Config.MainConfigOfPropertyValue;
import com.important.AnnotationDrive.bean.Boss;
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
	 * @Value,@PropertySource
	 */
	@Test
	public void test2() {
		AnnotationConfigApplicationContext annotationConfig = new AnnotationConfigApplicationContext(MainConfigOfPropertyValue.class);
		Person person = (Person) annotationConfig.getBean("person");
		System.out.println(person);
	}
	
	/**
	 * @Autowired,@Qualifier,@Primary
	 */
	@Test
	public void test3() {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(MainConfigOfAutowire.class);
		TestService bean = ac.getBean(TestService.class);
		System.out.println(bean);
		
		Boss boss = ac.getBean(Boss.class);
		System.out.println(boss);
	}
}
