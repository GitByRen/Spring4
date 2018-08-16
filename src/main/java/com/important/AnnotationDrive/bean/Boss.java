package com.important.AnnotationDrive.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Boss {

	private Car car;

	public Car getCar() {
		return car;
	}

	@Autowired  // 标注在方法上，Spring容器创建当前对象时，就会调用方法，完成赋值
	public void setCar(Car car) {
		this.car = car;
	}

}
