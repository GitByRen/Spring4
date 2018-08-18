package com.important.AnnotationDrive.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @EnableAspectJAutoProxy:开启基于注解的aop模式[<aop:aspectj-autoproxy></aop:aspectj-autoproxy>]
 * 
 * JoinPoint一定要出现在参数表的第一位
 */
@EnableAspectJAutoProxy
@Configuration
public class MainConfigOfAop {

}
