package com.java8.Streams;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.testng.annotations.Test;

public class StreamsIntermediateFunctions {

	// filter() - filter list or data

	@Test
	public void streamFilter() {
		List<String> list = Arrays.asList("krissh","biggie","chuy","nate","brett","jenny","bonso","kate","kristen");
		list.stream().filter(s->s.startsWith("b")).forEach(System.err::println);

		list.stream().filter(s->s.contains("ate")).forEach(s->System.out.println(s));
		
	}

	// map() -> modify or change list or data
	@Test
	public void streamMap() {
		List<Integer> list = Arrays.asList(9,5,1,3,8,5,3,7,4,0,4);
		list.stream().map(s->s*s).forEach(System.out::println);

		List<Double> dlist = Arrays.asList(9.0,5.0,1.0,3.0,8.0,5.0,3.0,7.0,4.0,0.0,4.0);
		dlist.stream().map(s->Math.sqrt(s)).forEach(System.err::println);
	}

	// flatmap() -> used to flatten list of lists
	@Test
	public void streamFlatMap() {

		List<List<String>> list = Arrays.asList(Arrays.asList("Hello","how"),Arrays.asList("are","you"));

		System.out.println(list);

		// Flattening to single list
		list.stream().flatMap(a->a.stream()).forEach(System.err::println);

		List<String> fruits = Arrays.asList("apple","banana","guava");

		List<String> seasonedfruits = Arrays.asList("mango","apple","banana","custrad apple");

		List<List<String>> yo = Arrays.asList(fruits,seasonedfruits);
		yo.stream().flatMap(b->b.stream()).forEach(System.out::println);
		yo.stream().flatMap(b->b.stream()).distinct().forEach(System.err::println);
	}

	// sorted() -> to sort
	@Test
	public void streamSort() {
		List<String> list = Arrays.asList("krissh","biggie","chuy","nate","brett","jenny","bonso","kate","kristen");
		list.stream().sorted().forEach(System.out::println);

		System.out.println("Sorting using lambda expression");
		list.stream().sorted((s1,s2)-> s1.compareTo(s2)).forEach(System.out::println);

		System.out.println("Sorting using lambda expression revrse order");
		list.stream().sorted((s1,s2)-> s2.compareTo(s1)).forEach(System.out::println);

		System.out.println("Sorting using comparator");
		list.stream().sorted(Comparator.naturalOrder()).forEach(System.out::println);

		System.out.println("Sorting using comparator");
		list.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
	}

	// limit() - limit the size
	@Test
	public void streamLimit() {
		List<Integer> list = Arrays.asList(9,5,1,3,8,5,3,7,4,0,4,19);
		// prinitng least 3 numbers
		list.stream().sorted((a,b)->a.compareTo(b)).distinct().limit(3).forEach(System.out::println);

		// prinitng highest 3 numbers
		list.stream().sorted((a,b)->b.compareTo(a)).distinct().limit(3).forEach(System.out::println);
		System.out.println("******** MAX ********");
		System.out.println(list.stream().collect(Collectors.maxBy((a,b)-> {return a-b;})).get());
		System.out.println(list.stream().max((a,b)->a.compareTo(b)).get());
		
		System.out.println("******** MIN ********");
		System.out.println(list.stream().collect(Collectors.minBy((a,b)-> {return a-b;})).get());
	}
	
	// skip() -> skip first n elements
	@Test
	public void streamSkip() {
		List<Integer> list = Arrays.asList(9,5,1,3,8,5,3,7,4,0,4);
		list.stream().distinct().skip(4).forEach(System.out::println);
		
		Map<String, Integer> map  = new TreeMap<String, Integer>();
		map.put("a",1);
		map.put("b", 2);
		map.put("c", 3);
		map.put("a", 4);
		System.out.println(map);
	}
	
}
