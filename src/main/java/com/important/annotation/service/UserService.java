package com.important.annotation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.important.annotation.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	// 当IOC容器里存在多个类型兼容的bean的时候(多个impl实现了一个接口)，可以通过@Qualifier("userRepositoryImpl")提供Bean的名称
	private UserRepository userRepository;

	public void add() {
		System.out.println("UserService add...");
		userRepository.save();
	}

}
