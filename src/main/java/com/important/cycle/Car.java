package com.important.cycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class Car implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean{

	public Car() {
		System.out.println("Car's Constructor...");
	}

	private String brand;

	public void setBrand(String brand) {
		System.out.println("setBrand...");
		this.brand = brand;
	}

	@Override
	public String toString() {
		return "Car [brand=" + brand + "]";
	}

	// 正在被实例化的bean的名字
	@Override
	public void setBeanName(String name) {
		System.out.println("setBeanName：" + name);
	}

	// 该方法可以传递Bean工厂
	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println("beanFactory：" + beanFactory);
	}

	// 该方法传递ApplicationContext
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("applicationContext：" + applicationContext);
	}

	// 在postProcessBeforeInitialization之后，自定义初始化方法之前执行
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("afterPropertiesSet()");
	}

	// 自定义初始化方法，在afterPropertiesSet之后，postProcessAfterInitialization之前执行
	private void init() {
		System.out.println("init...");
	}

	//implements DisposableBean，释放bean，不推荐，因为实现要实现接口
//	@Override
//	public void destroy() throws Exception {
//		
//	}
	
	// 自定义销毁方法
	public void destroy() {
		System.out.println("destroy...");
	}
	
}
