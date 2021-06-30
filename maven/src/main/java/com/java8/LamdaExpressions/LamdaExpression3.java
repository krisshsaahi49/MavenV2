package com.java8.LamdaExpressions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class LamdaExpression3 {

	@Test
	public void test1() {
		List<Integer> list = new ArrayList<Integer>(Arrays.asList(10, 56, 99, 9, 34, 78, 92, 18));
		Collections.sort(list, (a, b) -> {
			return a - b;
		});
		System.out.println(list);
		Collections.sort(list, (a, b) -> {
			return b - a;
		});
		System.out.println(list);

		list.forEach(new Consumer<Integer>() { // Using Consumer anonymous class

			public void accept(Integer i) {
				// TODO Auto-generated method stub
				System.out.println(i);
				Reporter.log(i.toString());
			}
		});

		list.forEach(i -> System.out.println(i)); // List to print using lambda expression

		list.forEach(System.out::println); // Lamda method refence

		list.forEach(Square::squareOfElements); // Lamda static method reference
	}
}

class Square{

	static void squareOfElements(Integer i) {
		System.out.println(i * i);
	}
}