package com.important.AnnotationDrive.bean;

import org.springframework.stereotype.Component;

@Component
public class Boss {

    private Car car;
    
    public Boss(Car car) {
        this.car = car;
        System.out.println("Boss有参构造器..");
    }

    public Car getCar() {
        return car;
    }

//    @Autowired
    // 标注在方法上，Spring容器创建当前对象时，就会调用方法，完成赋值
    // 方法用的参数，自定义类型的值从ioc获取
    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Boss [car=" + car + "]";
    }

}
