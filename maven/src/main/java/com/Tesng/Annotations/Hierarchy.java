package com.Tesng.Annotations;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Hierarchy {

	// Testng Hierarchy - STCM (suite, test, class, method)

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Before Suite");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("Before Class");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Before Method");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("Before Test");
	}

	@Test
	public void test1() {
		System.out.println("Test");
	}
	@Test
	public void test2() {
		System.out.println("Test 2");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("After Test");
	}
	

	@AfterMethod
	public void afterMethod() {
		System.out.println("After Method");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("After Class");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("After Suite");
	}
}
