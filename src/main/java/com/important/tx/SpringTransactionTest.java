package com.important.tx;

import java.util.Arrays;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTransactionTest {

	private ApplicationContext ctx = null;
	private BookShopDao bookShopDao = null;
	private BookShopService bookShopService = null;
	private Cashier cashier = null;

	{
		ctx = new ClassPathXmlApplicationContext("spring-jdbc.xml");
		bookShopDao = ctx.getBean(BookShopDao.class);
		bookShopService = ctx.getBean(BookShopService.class);
		cashier = ctx.getBean(Cashier.class);
	}

	// 测试事务的传播行为
	@Test
	public void testTransactionPropagation() {
		cashier.checkout("aa", Arrays.asList("1101", "1102"));
	}

	// 测试注解式事务
	@Test
	public void testBookShopService() {
		bookShopService.purchase("AA", "1101");
	}

	@Test
	public void testBookShopDaoUpdateUserAccount() throws BookException {
		bookShopDao.updateUserAccount("aa", 100);
	}

	@Test
	public void testBookShopDaoUpdate() {
		bookShopDao.updateBookStock("1100");
	}

	@Test
	public void testBookShopDao1() {
		double findBookPriceByIsbn = bookShopDao.findBookPriceByIsbn("1100");
		System.out.println(findBookPriceByIsbn);
	}
}
