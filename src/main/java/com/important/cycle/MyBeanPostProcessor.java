package com.important.cycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * 后置处理器
 *
 */
public class MyBeanPostProcessor implements BeanPostProcessor {

	// 在bean实例化，依赖注入之后及自定义初始化方法(例如：配置文件中bean标签添加init-method属性指定Java类中初始化方法、
	// @PostConstruct注解指定初始化方法，Java类实现InitailztingBean接口)之前调用
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("postProcessBeforeInitialization:" + bean + ", " + beanName);
		return bean;
	}
	
	//在bean实例化、依赖注入及自定义初始化方法之后调用
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("postProcessAfterInitialization:" + bean + ", " + beanName);
		Car car = new Car();
		car.setBrand("aaa");
		return car;
	}

}
