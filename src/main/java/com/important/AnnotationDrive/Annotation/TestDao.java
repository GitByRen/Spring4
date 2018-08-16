package com.important.AnnotationDrive.Annotation;

import org.springframework.stereotype.Repository;

@Repository
public class TestDao {

	private String lable = "1";

	public String getLable() {
		return lable;
	}

	public void setLable(String lable) {
		this.lable = lable;
	}

	@Override
	public String toString() {
		return "TestDao [lable=" + lable + "]";
	}

}
