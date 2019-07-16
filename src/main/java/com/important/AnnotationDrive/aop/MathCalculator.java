package com.important.AnnotationDrive.aop;

// 类没有环绕通知
@NoRepeatSubmit(submitTime = 10)
public class MathCalculator {

	@NoRepeatSubmit(submitTime = 3)
	public int div(int i, int j) {
		System.out.println("MathCalculator...div...");
		return i / j;
	}

}
