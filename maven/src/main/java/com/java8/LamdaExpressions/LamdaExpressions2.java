package com.java8.LamdaExpressions;

public class LamdaExpressions2 {

	public static void main(String[] args) {
		
		// Return keyword not required for single lamda statement
		MathOperation operation = (a,b) -> a+b;
		System.out.println(operation.add(2, 3));
		
		//	Return keyword required for multiple lamda statements	
		MathOperation operation1 = (a,b) -> {
			return a+b;
		};
		System.out.println(operation1.add(100, 300));
	}

}
