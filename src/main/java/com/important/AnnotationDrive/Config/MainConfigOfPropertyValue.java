package com.important.AnnotationDrive.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.important.AnnotationDrive.bean.Person;

// 加载外部配置文件，获取key/value值保存到运行的环境变量中
@PropertySource({"classpath:/person.properties"})
@Configuration
public class MainConfigOfPropertyValue {

	@Bean
	public Person person() {
		return new Person();
	}
	
}
