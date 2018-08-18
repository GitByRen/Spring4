package com.important.mvc;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 在WEB中应用Spring的基本思路
 * ①在web服务器启动时就创建IOC容器
 * ②放到ServletContext域中
 */
public class SpringServletContextListener implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// 1.获取Spring配置文件的名称
		ServletContext servletContext = sce.getServletContext();
		String config = servletContext.getInitParameter("configLocation");
		
		// 2.创建IOC容器
		ApplicationContext ac = new ClassPathXmlApplicationContext(config);
		
		// 3.把IOC容器放在ServletContext容器中
		servletContext.setAttribute("ApplicationContext", ac);
	}
	
}
