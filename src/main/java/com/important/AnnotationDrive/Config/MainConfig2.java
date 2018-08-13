package com.important.AnnotationDrive.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

import com.important.AnnotationDrive.Configuration.Person;
import com.important.AnnotationDrive.condition.LinuxCondition;
import com.important.AnnotationDrive.condition.WindowsCondition;

//类中组件统一设置。满足当前条件，这个类中配置的所有bean注册才能生效；
//@Conditional({WindowsCondition.class})
@Configuration
public class MainConfig2 {

	// 默认是单例的
	/**
	 * ConfigurableBeanFactory#SCOPE_PROTOTYPE  
	 * ConfigurableBeanFactory#SCOPE_SINGLETON  单实例
	 * org.springframework.web.context.WebApplicationContext#SCOPE_REQUEST  request
	 * org.springframework.web.context.WebApplicationContext#SCOPE_SESSION  session
	 * singleton：ioc容器启动就会创建对象
	 * prototype：每次获取的时候才会创建对象
	 * 
	 * 懒加载：容器启动先不创建对象，第一次使用(获取)Bean再创建对象，专门针对单例
	 */
//	@Scope("prototype")
//	@Lazy
	@Bean
	public Person person() {
		System.out.println("给容器中添加Person");
		return new Person("aabs", 12);
	}

	/**
	 * @Conditional:按照一定的条件进行判断，满足条件则注册bean
	 * 
	 * 如果系统是Windows，给容器中注册("bill")
	 * 如果系统是Linux，给容器中注册("linus")
	 */
	@Conditional(WindowsCondition.class)
	@Bean("bill")
	public Person person01() {
		return new Person("BillGates", 62);
	}
	
	@Conditional(LinuxCondition.class)
	@Bean("linus")
	public Person person02() {
		return new Person("linus", 50);
	}
	
	/**
	 * 给容器中注册组件；
	 * 1）、包扫描+组件标注注解（@Controller/@Service/@Repository/@Component）[自己写的类]
	 * 2）、@Bean[导入的第三方包里面的组件]
	 * 3）、@Import[快速给容器中导入一个组件]
	 * 		1）、@Import(要导入到容器中的组件)；容器中就会自动注册这个组件，id默认是全类名
	 * 		2）、ImportSelector:返回需要导入的组件的全类名数组；
	 * 		3）、ImportBeanDefinitionRegistrar:手动注册bean到容器中
	 * 4）、使用Spring提供的 FactoryBean（工厂Bean）;
	 * 		1）、默认获取到的是工厂bean调用getObject创建的对象
	 * 		2）、要获取工厂Bean本身，我们需要给id前面加一个&
	 * 			&colorFactoryBean
	 */
	
}
