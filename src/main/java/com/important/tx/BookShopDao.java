package com.important.tx;

public interface BookShopDao {

	// 根据书号获取书的单价
	public double findBookPriceByIsbn(String isbn);
	
	// 更新书的库存
	public void updateBookStock(String isbn);
	
	// 更新用户的账户余额
	public void updateUserAccount(String username, double price);
}
