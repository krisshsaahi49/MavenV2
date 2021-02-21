package com.java.Performance;

import org.testng.annotations.Test;

public class StaticVariablePerformance {

	@Test
	public void withoutStatic() {
		for (int i = 1; i <= 100000000; i++) {
			Employee emp = new Employee("Employee "+i,i,"Google");
		}
		
		System.out.println((Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory())/1024);
	}
	
	@Test
	public void withStatic() {
		for (int i = 1; i <= 100000000; i++) {
			Employee1 emp = new Employee1("Employee "+i,i);
		}
		
		System.out.println((Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory())/1024);
	}
}
