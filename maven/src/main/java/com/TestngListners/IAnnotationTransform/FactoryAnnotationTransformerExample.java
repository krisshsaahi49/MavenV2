package com.TestngListners.IAnnotationTransform;

import org.testng.annotations.Factory;
import org.testng.annotations.Test;

public class FactoryAnnotationTransformerExample {
	private String name;

	@Factory
	public FactoryAnnotationTransformerExample(String name) {
		this.name = name;
		System.out.println("In constructor: " + name);
	}

	@Test
	public void testcase1() {
		System.out.println("Method is testcase1, name is " + name);
	}
}
