package com.TestngListners.IAnnotationTransform;

import org.testng.annotations.Test;

public class DataProviderAnnotationTransformerExample {

	@Test(dataProvider = "getDp3", dataProviderClass = DataProviderFactory.class)
	public void largeDataTest(String param) {
		System.out.println("DataProviderAnnotationTransformerExample Method is "+Thread.currentThread().getStackTrace()[1].getMethodName()+", parameter is " + param
				+ " threadId: " + Thread.currentThread().getId());
	}
}
