package com.TestngListners.IAnnotationTransform;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.IConfigurationAnnotation;
import org.testng.annotations.IDataProviderAnnotation;
import org.testng.annotations.IFactoryAnnotation;
import org.testng.annotations.ITestAnnotation;

public class DataProviderAnnotationTransformerListener implements IAnnotationTransformer {

	@Override
	public void transform(IDataProviderAnnotation annotation, Method method) {
		if (annotation.getName().equals("getDp3")) {
			System.out.println("In getDP3, run parallely");
			annotation.setParallel(true);
		}
	}

	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
	}

	@Override
	public void transform(IFactoryAnnotation annotation, Method method) {
	}

	@Override
	public void transform(IConfigurationAnnotation annotation, Class testClass, Constructor testConstructor,
			Method testMethod) {
	}
}