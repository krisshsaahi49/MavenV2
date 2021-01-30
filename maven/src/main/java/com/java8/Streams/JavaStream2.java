package com.java8.Streams;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class JavaStream2 {

	public static void main(String[] args) {

//		Print integers using foreach loop
		IntStream.range(1, 10).forEach(System.out::print);
		System.out.println();

//		Print integers using lamda expressions
		IntStream.rangeClosed(1, 10).forEach(x -> System.out.print(x));
		System.out.println();

//		Sum of integers
		System.out.println(IntStream.rangeClosed(1, 100).sum());
		System.out.println();
		
//		Sort -> find first element and print
		Stream.of("Krissh","Ryuzaki","Neo","Amber").sorted().findFirst().ifPresent(System.out::print);
		System.out.println();
		
		String[] str = {"Tank","Cypher","Morpheus","Smith","Oracle","Trinity"};
		Stream.of(str).filter(x->x.startsWith("T")).sorted().forEach(System.out::print);
		System.out.println();
		
		Arrays.stream(new int[] {1,2,3,4}).map(x->x*x).forEach(System.out::print);System.out.println();
		
		int[] digits = new int[] {1,2,3,4,5,6,7};
		Arrays.stream(digits).average().ifPresent(System.err::println);
		Arrays.stream(digits).min().ifPresent(x->System.out.println("Minimum value : "+x));
		Arrays.stream(digits).mapToDouble(x->x).max().ifPresent(System.out::println);
		
		Arrays.stream(str).map(x->x.toLowerCase()).forEach(System.err::println);
		Arrays.stream(str).map(String::toUpperCase).forEach(System.err::println);
		Arrays.stream(str).filter(x->x.startsWith("T")).map(x->x.toUpperCase()).map(x->x.toLowerCase()).forEach(System.out::println);
	}

}
