package com.important.AnnotationDrive.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.important.AnnotationDrive.bean.Car;

/**
 * 容器bean的生命周期
 * 1)、指定初始化和销毁方法
 * 		通过@Bean指定initMethod和destroyMethod
 * 2)、通过实现InitializingBean（定义初始化逻辑），DisposableBean（定义销毁逻辑）
 * 3)、可以使用JSR250：@PostConstruct在bean创建完成并且属性赋值完成，来执行初始化方法
 * 		@PreDestroy：在容器销毁Bean之前通知我们进行清理工作（两个注解加在实体类初始化和销毁方法上）
 * 4)、BeanPostProcessor：Bean的后置处理器；在bean的初始化前后进行一些处理。
		// 为bean属性赋值
  		populateBean(beanName, mbd, instanceWrapper);
		initializeBean {
			// 遍历得到容器中所有的BeanPostProcessor，挨个执行postProcessBeforeInitialization方法，一旦返回null，
			// 跳出for循环，不会执行后面的BeanPostProcessor 
			applyBeanPostProcessorsBeforeInitialization(wrappedBean, beanName);
			invokeInitMethods(beanName, wrappedBean, mbd); //执行初始化方法
			applyBeanPostProcessorsAfterInitialization(wrappedBean, beanName);
		}
 */
@ComponentScan("com.important.AnnotationDrive.bean")
@Configuration
public class MainConfigOfLifeCycle {

	/**
	 * 销毁：
	 *   单实例：容器关闭时进行销毁
	 *   多实例：容器不会管理bean
	 */
//	@Scope("prototype")
	@Bean(initMethod="init",destroyMethod="destory")
	public Car car() {
		return new Car();
	}
	
}
