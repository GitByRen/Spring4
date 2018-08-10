package com.important.jdbc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

public class JdbcTest {

	private ApplicationContext ctx = null;
	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	{
		ctx = new ClassPathXmlApplicationContext("spring-jdbc.xml");
		jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
		namedParameterJdbcTemplate = (NamedParameterJdbcTemplate) ctx.getBean("namedParameterJdbcTemplate");
	}

	/**
	 * 可以为参数起名字
	 */
	@Test
	public void testNamedParameterJdbcTemplate() {
		String sql = "insert into employees(last_name,email,dept_id) values(:ln,:email,:dept_id)";
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("ln", "FF");
		paramMap.put("email", "ff@atguigu.com");
		paramMap.put("dept_id", 2);
		namedParameterJdbcTemplate.update(sql, paramMap);
	}
	
	
	public void testNamedParameterJdbcTemplate2() {
		String sql = "insert into employees(last_name,email,dept_id) values(:lastName,:email,:deptId)";
		Employee employee = new Employee();
		employee.setLastName("XYZ");
		employee.setEmail("xyz@sina.com");
		employee.setDpetId(3);
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(employee);
		namedParameterJdbcTemplate.update(sql, paramSource);
	}
	
	/**
	 * insert,update,delete
	 */
	@Test
	public void testUpdate() {
		String sql = "update user set username = ? where id = ?";
		jdbcTemplate.update(sql, "Jack", 8);
	}

	@Test
	public void testBatchUpdate() {
		String sql = "insert into user(username,password,age,sex) values(?,?,?,?)";
		List<Object[]> batchArgs = new ArrayList<>();
		batchArgs.add(new Object[] { "AA", "password1", 10, 1 });
		batchArgs.add(new Object[] { "BB", "password2", 11, 2 });
		batchArgs.add(new Object[] { "CC", "password3", 12, 3 });
		jdbcTemplate.batchUpdate(sql, batchArgs);
	}

	/**
	 * 1.其中的RowMapper指定如何去映射结果集的行，常用的实现类为BeanPropertyRowMapper
	 * 2.不支持级联属性(无法给department.id赋值)
	 */
	@Test
	public void testQueryForObject() {
		String sql = "SELECT id,last_name lastName, email FROM employees where id = ?";
		// 注意不是调用此方法
//		Employee employee = jdbcTemplate.queryForObject(sql, Employee.class, 1);
		RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(Employee.class);
		Employee employee = jdbcTemplate.queryForObject(sql, rowMapper, 1);
		System.out.println(employee);
	}

	/**
	 * 1.查找实体类的集合 
	 * 2.注意不是queryForList
	 */
	@Test
	public void testQueryForList() {
		String sql = "SELECT id,last_name lastName, email FROM employees where id > ?";
		RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(Employee.class);
		List<Employee> queryForList = jdbcTemplate.query(sql, rowMapper, 5);
		System.out.println(queryForList);
	}

	/**
	 * 获取单个列的值，或做统计查询
	 */
	@Test
	public void testQueryForObject2() {
		String sql = "SELECT count(id) from employees";
		Long count = jdbcTemplate.queryForObject(sql, Long.class);
		System.out.println(count);
	}
}
