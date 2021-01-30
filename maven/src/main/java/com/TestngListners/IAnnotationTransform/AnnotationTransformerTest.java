package com.TestngListners.IAnnotationTransform;

import org.testng.annotations.Factory;
import org.testng.annotations.Test;

public class AnnotationTransformerTest {
	@Test(alwaysRun = true)
	public void test1() {
		System.out.println("This is my first test whose behaviour would get changed while executing");
	}

	@Test
	public void test2() {
		System.out.println("This is my second test executing");
	}
	
	@Test
	public void test3() {
		System.out.println("This is my third test executing");
	}
	
}
