package com.TestngListners.IAnnotationTransform;

import org.testng.annotations.DataProvider;

public class DataProviderFactory {
	@DataProvider
	public static Object[][] getDp1() {
		return new Object[][] { { "apple" }, { "banana" }, { "mango" } };
	}

	@DataProvider
	public static Object[][] getDp2() {
		return new Object[][] { { "a" }, { "b" }, { "m" } };
	}

	@DataProvider(name = "getDp3")
	public static Object[][] getDp3() {
		return new Object[][] { { "river" }, { "book" }, { "bank" } };
	}

	/*
	 * @DataProvider(name = "constructorParams") public static Object[][]
	 * getConstructorParams() { return new Object[][] { { "1" }, { "2" }, { "3" } };
	 * }
	 */
	
	@DataProvider(name="getDP4ConstructorParams")
    public static Object[][] getConstructorParams() {
        return new Object[][]{{"Constructordata 1"}, {"Constructor data 2"}, {"Constructor data 3"}};
    }
}