package com.java8.LamdaExpressions;

public class LamdaExpressions1 {

	public static void main(String[] args) {
		
//		Anonymous inner class
		City c = new City() {
			
			@Override
			public String getCity() {
				// TODO Auto-generated method stub
				return "Zurich";
			}
		};
		
		System.out.println(c.getCity());
		
//		Lamda Expressions
		City cLamda = () -> {return "Munich";};
		System.out.println(cLamda.getCity());
	}

}
