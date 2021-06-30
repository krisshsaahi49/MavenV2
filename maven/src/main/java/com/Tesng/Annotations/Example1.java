package com.Tesng.Annotations;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Example1 extends Hierarchy{

	@Test
	public void test1() {
		System.out.println("******************* Test 1 **********************");
	}
	
	@Test(invocationCount = 10)
	public void test2() {
		System.out.println("******************* Test 2 **********************");
	}
}
