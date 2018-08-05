package com.important.annotation.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.important.annotation.TestObject;

@Repository("userRepository")
public class UserRepositoryImpl implements UserRepository{
	
	// 若某一属性值允许不被设置，可以设置@Autowired(required=false)
	@Autowired(required=false)
	private TestObject test;
	
	@Override
	public void save() {
		System.out.println("UserRepository Save...");
	}

}
