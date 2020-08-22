package javaPatterns.j2e.creationalDesignPattern.factoryMethodPattern;

public class GetInterestFactory {
	enum BANK{
		AXIS,SBI;
	}
	
	public Interest factory(BANK bank) {
		if(BANK.AXIS==bank) {
			return new AXIS();
		}else if(BANK.SBI==bank) {
			return new SBI();
		}
		return null;
	}
}
