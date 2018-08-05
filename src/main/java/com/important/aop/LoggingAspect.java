package com.important.aop;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

// 把这个类声明为一个切面：需要把该类放入到IOC容器，再声明为一个切面
//@Order(2) 指定切面的优先级，值越小优先级越高
@Aspect
@Component
public class LoggingAspect {

	/**
	 * 定义一个方法，用于声明切入点表达式.一般的，该方法中再不需要填入其他的代码
	 * 使用@Pointcut来声明切入点表达式
	 */
	@Pointcut("execution(* com.important.aop.*.*(int, int))")
	public void declareJointPointExpression() {}
	
	// 声明该方法是一个前置通知
	@Before("declareJointPointExpression()")
	public void beforeMethod(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		List<Object> args = Arrays.asList(joinPoint.getArgs());
		System.out.println("The method " + methodName + " begins with " + args);
	}

	// 后置通知：在目标方法执行后(无论是否发生异常),执行通知，但是不能访问目标方法执行的结果
	@After("declareJointPointExpression()")
	public void afterMethod(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method " + methodName + " ends");
	}

	// 返回通知：在目标方法正常结束后执行的代码，可以访问到方法的返回值
	@AfterReturning(value = "declareJointPointExpression()", returning = "result")
	public void afterReturning(JoinPoint joinPoint, Object result) {
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method " + methodName + " ends with " + result);
	}

	// 异常通知：在目标方法出现异常时会执行的代码，可以访问到异常对象，且可以指定异常类型 NullPointException e
	@AfterThrowing(value = "declareJointPointExpression()", throwing = "ex")
	public void afterThrowing(JoinPoint joinPoint, Exception ex) {
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method " + methodName + " occurs exception: " + ex);
	}
	
	/*
	 *  环绕通知需要携带ProceedingJoinPoint类型的参数.
	 * 环绕通知类似于动态代理的全过程：ProceedingJoinPoint类型的参数决定是否执行目标方法.
	 * 且环绕通知必须有返回值，返回值即为目标方法的返回值
	 */
	@Around("execution(* com.important.aop.*.*(int, int))")
	public Object aroundMethod(ProceedingJoinPoint pjd) {
		Object result = null;
		String methodName = pjd.getSignature().getName();
		// 执行目标方法
		try {
			// 前置通知
			System.out.println("The method " + methodName + " begins with " + Arrays.asList(pjd.getArgs()));
			result = pjd.proceed();
			// 返回通知...
		} catch (Throwable e) {
			// 异常通知...
		}
		
		// 后置通知...
		
		return result;
	}
}
