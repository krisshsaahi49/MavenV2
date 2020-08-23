package com.java8.LamdaExpressions;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class LamdaForeach {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i <= 5; i++)
			list.add(i);
		// Foreach using lamdaExpressions
		list.forEach(h -> System.out.println("Lamda : "+h));
		
		// Foreach anonymous consumer implementation
		list.forEach(new Consumer<Integer>() {

			@Override
			public void accept(Integer t) {
				System.out.println("Consumer anonymous : "+t);
			}
			
		});
	}

}
