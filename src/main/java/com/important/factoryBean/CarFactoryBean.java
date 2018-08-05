package com.important.factoryBean;

import org.springframework.beans.factory.FactoryBean;

/**
 * FactoryBean配置Bean
 */
public class CarFactoryBean implements FactoryBean<Car>{

	private String brand;
	
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	// 返回bean的对象
	@Override
	public Car getObject() throws Exception {
		return new Car(brand, 500000);
	}

	// 返回的bean的类型
	@Override
	public Class<?> getObjectType() {
		return Car.class;
	}

	@Override
	public boolean isSingleton() {
		
		return false;
	}

}
