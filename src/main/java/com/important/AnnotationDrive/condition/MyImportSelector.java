package com.important.AnnotationDrive.condition;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

// 自定义组件
public class MyImportSelector implements ImportSelector {

	/**
	 * AnnotationMetadata：当前标注@Import注解的类的所有注解信息
	 */
	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		return new String[] {"com.important.AnnotationDrive.bean.Blue","com.important.AnnotationDrive.bean.Yellow"};
	}

}
