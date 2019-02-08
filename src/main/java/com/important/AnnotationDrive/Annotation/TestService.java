package com.important.AnnotationDrive.Annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class TestService {

	@Qualifier("testDao")
	@Autowired
	private TestDao testDao;

	@Override
	public String toString() {
		return "TestService [testDao=" + testDao + "]";
	}

}
