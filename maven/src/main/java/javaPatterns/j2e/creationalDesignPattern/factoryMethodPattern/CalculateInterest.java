package javaPatterns.j2e.creationalDesignPattern.factoryMethodPattern;

import javaPatterns.j2e.creationalDesignPattern.factoryMethodPattern.GetInterestFactory.BANK;

public class CalculateInterest {

	public static void main(String[] args) {
		
		GetInterestFactory getInterest = new GetInterestFactory();
		Interest i = getInterest.factory(BANK.SBI);
		Interest i1 = (new GetInterestFactory()).factory(BANK.AXIS);
		System.out.println("ROI : "+i.getInterest());
		System.out.println(Interest.method());
		System.out.println(i.method2());
	}

}
