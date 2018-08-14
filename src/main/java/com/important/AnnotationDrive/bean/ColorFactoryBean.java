package com.important.AnnotationDrive.bean;

import org.springframework.beans.factory.FactoryBean;

//创建一个Spring定义的FactoryBean
public class ColorFactoryBean implements FactoryBean<Color>{

	@Override
	public Color getObject() throws Exception {
		return new Color();
	}

	@Override
	public Class<?> getObjectType() {
		return Color.class;
	}

	// 控制是否单例,true单例,false多例
	@Override
	public boolean isSingleton() {
		return true;
	}

	
	
}
