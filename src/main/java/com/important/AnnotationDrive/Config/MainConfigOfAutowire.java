package com.important.AnnotationDrive.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import com.important.AnnotationDrive.Annotation.TestDao;
import com.important.AnnotationDrive.bean.Car;
import com.important.AnnotationDrive.bean.Cat;
import com.important.AnnotationDrive.bean.Color;
import com.important.AnnotationDrive.bean.ColorFactoryBean;
import com.important.AnnotationDrive.bean.MyBeanPostProcessor;

/**
 * 1、
 * @Autowired：
 * 1）默认优先按照类型去容器中找对应的组件：TestDao.class
 * 2）如果找到多个相同类型的组件，再将属性名作为组件的id去容器查找（testDao）
 * 
 * @Qualifier("xxx")：
 * 1）使用@Qualifier指定需要装配的组件id，而不是使用属性名
 * 2）找不到bean就报错
 * 
 * @Autowired(required=false)：有就装配，没有就不装配
 * 
 * @Primary：让Spring进行自动装配时，默认使用首选的bean，@Qualifier优先级大于@Primary
 * 
 * 2、Spring还支持使用@Resource(JSR250)和@Inject(JSR330)[java规范的注解]
 * 		@Resource:
 * 			可以和@Autowired一样实现自动装配功能；默认是按照组件名称进行装配的；
 * 			没有能支持@Primary功能，没有支持@Autowired（reqiured=false）;
 * 		@Inject:
 * 			需要导入javax.inject的包，和Autowired的功能一样。没有required=false的功能；
 * 
 * 3、@Autowired：构造器，参数，方法，属性；都是从容器中获取参数组件的值
 *      1）、标注在方法位置：@Bean+方法参数，默认不写@Autowired
 *      2）、标在构造器上：如果组件只有一个有参构造器，这个有参构造器的@Autowired可以省略
 *      3）、放在参数位置
 * 
 * 4、自定义组件实现XXXAware，在创建对象的时候，会调用接口规定的方法注入相关组件；
 *   Aware：把Spring底层的一些组件注入到自定义的Bean中
 */
@Configuration
@ComponentScan(value = { "com.important.AnnotationDrive.Annotation",
		"com.important.AnnotationDrive.bean" }, excludeFilters = {
				@Filter(type = FilterType.ASSIGNABLE_TYPE, classes = { ColorFactoryBean.class,
						MyBeanPostProcessor.class, Cat.class }) })
public class MainConfigOfAutowire {

//	@Primary
	@Bean
	public TestDao testDao() {
		TestDao bookDao = new TestDao();
		bookDao.setLable("2");
		return bookDao;
	}
	
	/**
	 * @Bean标注的方法创建对象的时候，方法参数的值从容器中获取
	 * @param car
	 * @return
	 */
	@Bean
	public Color color(Car car) {
	    Color color = new Color();
	    color.setCar(car);
	    return color;
	}
}
