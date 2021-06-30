package com.java.encapsulation;

import org.testng.annotations.Test;

public class FunctionalInterExamples {
	
	interface func1 {
		int add(int a , int b);
	}
	
	public int operate(int a, int b,func1 obj) {
		return obj.add(a, b);
	}
	
	@Test
	public void testFuncInterface() {
		func1 f1 = (a,b ) -> {return a+b;};
		func1 f2 = (a,b) -> {return a-b;};
		
		FunctionalInterExamples o = new FunctionalInterExamples();
		System.out.println(o.operate(8, 5, f1));
		System.out.println(o.operate(8, 5, f2));
	}

}
