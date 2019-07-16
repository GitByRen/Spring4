package com.important.AnnotationDrive.aop;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class NoRepeatSubmitAspect {

	@Pointcut("@annotation(com.important.AnnotationDrive.aop.NoRepeatSubmit)")
	public void pointCut() {
	}

	/**
	 * within：匹配所有持有指定注解类型内的方法
	 */
//	@Before("pointCut()")
//	@Before("@within(NoRepeatSubmit)")
	@Before("@within(noRepeat)")
	public void beforeNoRepeat(NoRepeatSubmit noRepeat) {
		System.out.println("注解中的值：" + noRepeat.submitTime());
		System.out.println("进来了");
	}
	
	@After("pointCut()")
	public void afterNoRepeat() {
		System.out.println("后置");
	}
	
	// 对@NoRepeatSubmit注解标注的方法进行环绕通知
	@Around("@annotation(noRepeatSubmit)")
	public Object noRepeatSubmitAround(ProceedingJoinPoint pjd, NoRepeatSubmit noRepeatSubmit) {
		System.out.println("***************************************");
		System.out.println("注解中的值：" + noRepeatSubmit.submitTime());
		// 被自定义注解的类
		System.out.println(pjd.getSignature().getDeclaringType());
		// 获取方法名及参数
		String methodName = pjd.getSignature().getName();
		System.out.println("The method " + methodName + " begins with " + Arrays.asList(pjd.getArgs()));
		Object proceed = null;
		try {
			proceed = pjd.proceed();
			
			// 返回通知
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("========================================");
		return proceed;
	}
	
}
