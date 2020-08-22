package javaPatterns.j2e.creationalDesignPattern.factoryMethodPattern;

public interface Interest {

	// interface has abstract, default and static methods only in java 8 and private methods too in JAVA 9s
	
	double getInterest();
	
	static String method() {
		System.out.println("I am a static method.........");
		return "I am a static method.........";
	}
	
	default String method2() {
		System.out.println("I am a default method.......");
		return "I am a default method.......";
	}
}
