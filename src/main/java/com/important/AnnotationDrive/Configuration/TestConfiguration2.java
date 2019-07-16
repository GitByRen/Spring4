package com.important.AnnotationDrive.Configuration;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.important.AnnotationDrive.Annotation.TestService;
import com.important.AnnotationDrive.Config.MainConfigOfAop;
import com.important.AnnotationDrive.Config.MainConfigOfAutowire;
import com.important.AnnotationDrive.Config.MainConfigOfLifeCycle;
import com.important.AnnotationDrive.Config.MainConfigOfProfile;
import com.important.AnnotationDrive.Config.MainConfigOfPropertyValue;
import com.important.AnnotationDrive.aop.MathCalculator;
import com.important.AnnotationDrive.bean.Boss;
import com.important.AnnotationDrive.bean.Car;
import com.important.AnnotationDrive.bean.Color;
import com.important.AnnotationDrive.bean.Person;
import com.important.AnnotationDrive.bean.Red;

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
	 * @Autowired,@Qualifier,@Primary,Aware
	 */
	@Test
	public void test3() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(MainConfigOfAutowire.class);
        TestService bean = ac.getBean(TestService.class);
        System.out.println(bean);

        Boss boss = ac.getBean(Boss.class);
        System.out.println(boss);
        Car car = ac.getBean(Car.class);
        System.out.println(car);
        Color color = ac.getBean(Color.class);
        System.out.println(color);
        Red red = ac.getBean(Red.class);
        System.out.println(red);
        ac.close();
	}
	
	/**
	 * @Profile
	 * 
	 * 怎样使该注解起作用：
	 * 1、使用命令行参数 -Dspring.profiles.active=test
	 * 2、代码方式
	 */
	@Test
	public void test4() {
	    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
	    // 设置需要激活的环境
	    ac.getEnvironment().setActiveProfiles("test","prod");
	    // 注册主配置类
	    ac.register(MainConfigOfProfile.class);
	    // 启动刷新
	    ac.refresh();
	    
	    String[] namesForType = ac.getBeanNamesForType(DataSource.class);
	    for (String string : namesForType) {
            System.out.println(string);
        }
	    
	    ac.close();
	}
	
	/**
	 * aop
	 */
	@Test
	public void test5() {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(MainConfigOfAop.class);
		MathCalculator bean = ac.getBean(MathCalculator.class);
        System.out.println(bean.div(3, 4));
        ac.close();
	}
	
	/**
	 * aop for annotation
	 */
	@Test
	public void test6() {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(MainConfigOfAop.class);
		MathCalculator bean = ac.getBean(MathCalculator.class);
        System.out.println(bean.div(2, 3));
        ac.close();
	}
	
}
