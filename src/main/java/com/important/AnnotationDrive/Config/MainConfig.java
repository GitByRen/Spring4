package com.important.AnnotationDrive.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;

import com.important.AnnotationDrive.bean.Person;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

// 指定这是一个配置类
@Configuration
// value：指定要扫描的包
// excludeFilters = Filter[]：指定扫描的时候按照什么规则排除哪些组件
// includeFilters = Filter[]：指定扫描的时候只需要包含哪些组件
// @ComponentScans 指定多个componentScan
/*
@ComponentScan(value = "com.important.AnnotationDrive.Annotation", excludeFilters = {
		@Filter(type = FilterType.ANNOTATION, classes = { Controller.class, Service.class }) })
*/
@ComponentScan(value = "com.important.AnnotationDrive.Annotation", includeFilters = {
//		@Filter(type = FilterType.ANNOTATION, classes = { Controller.class }),
//		@Filter(type = FilterType.ASSIGNABLE_TYPE, classes = { TestService.class }),
		@Filter(type = FilterType.CUSTOM, classes = { MyTypeFilter.class })}, useDefaultFilters = false)
/**
 * FilterType：
 * ANNOTATION：按照注解 
 * ASSIGNABLE_TYPE：按照给定的类型
 * ASPECTJ:使用ASPECTJ表达式
 * REGEX：正则表达式
 * CUSTOM：自定义规则
 */
public class MainConfig {

	// @Bean("persons")
	@Bean
	public Person person() {
		return new Person("aab", 12);
	}

}
