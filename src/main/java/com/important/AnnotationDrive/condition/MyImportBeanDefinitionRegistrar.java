package com.important.AnnotationDrive.condition;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import com.important.AnnotationDrive.bean.RainBow;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

	/**
	 * BeanDefinitionRegistry：BeanDefinition注册类
	 * 把所有需要添加到容器中的bean,调用BeanDefinitionRegistry.registerBeanDefinition手工进行祖册
	 */
	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		boolean red = registry.containsBeanDefinition("com.important.AnnotationDrive.bean.Red");
		boolean blue = registry.containsBeanDefinition("com.important.AnnotationDrive.bean.Blue");
		if (red && blue) {
			// 指定Bean的定义信息
			RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(RainBow.class);
			// 自定义bean名
			registry.registerBeanDefinition("rainBow", rootBeanDefinition);
		}
	}

}
