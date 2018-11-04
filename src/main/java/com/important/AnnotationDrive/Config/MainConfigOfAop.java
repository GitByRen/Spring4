package com.important.AnnotationDrive.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.important.AnnotationDrive.aop.LogAspects;
import com.important.AnnotationDrive.aop.MathCalculator;

/**
 * @EnableAspectJAutoProxy:开启基于注解的aop模式[<aop:aspectj-autoproxy></aop:aspectj-autoproxy>]
 * JoinPoint一定要出现在参数表的第一位
 */
@EnableAspectJAutoProxy
@Configuration
public class MainConfigOfAop {

	// 业务逻辑类加入容器中
	@Bean
	public MathCalculator calculator() {
		return new MathCalculator();
	}

	// 切面类加入到容器中
	@Bean
	public LogAspects logAspects() {
		return new LogAspects();
	}

}
