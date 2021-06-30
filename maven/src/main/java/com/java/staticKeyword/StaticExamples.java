package com.java.staticKeyword;

public class StaticExamples {

	// static is a non - access modifier unlike public, private, default and protected
	// static is applied on variables,methods,blocks and inner classes

	private static int i=abc();

	static {					// static block
		System.out.println("Static block is initialised...");
		System.out.println("******"+i*4+"**********");
	}

	public static void main(String[] args) {
		System.out.println(i);
	}

	static private int abc() {	// static method
		System.out.println("setting to static variable");
		return 2;
	}
	
	private void abcd() {		// instance method
		System.out.println(i);
	}
}
