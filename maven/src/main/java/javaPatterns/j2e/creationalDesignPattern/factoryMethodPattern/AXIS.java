package javaPatterns.j2e.creationalDesignPattern.factoryMethodPattern;

public class AXIS implements Interest{

	@Override
	public double getInterest() {
		
		return 6.95;
	}
	
	AXIS(){
		System.out.println("I am triggered");
	}

}
