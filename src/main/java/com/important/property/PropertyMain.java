package com.important.property;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PropertyMain {

	public static void main(String[] args) throws SQLException {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans-properties.xml");
		DataSource ds = (DataSource) ac.getBean("dataSource");
		System.out.println(ds.getConnection());
	}
	
}
