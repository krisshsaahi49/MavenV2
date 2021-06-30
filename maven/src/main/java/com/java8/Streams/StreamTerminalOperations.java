package com.java8.Streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class StreamTerminalOperations {

	@Test
	public void streamForeach() {
		List<String> list = Arrays.asList("krissh","biggie","chuy","nate","brett","jenny","bonso","kate","kristen");	
		list.stream().forEach(a->System.out.println(a));
		System.out.println("***********");
		list.stream().forEachOrdered(a->System.out.println(a));
		
		System.out.println("+++++++++++++++++++++++++++++++");
		list.parallelStream().forEach(System.out::println);
		System.out.println("-------------------------------");
		list.parallelStream().forEachOrdered(System.out::println);
	}
	
	@Test
	public void collectToMap() {
		List<String> list = Arrays.asList("Krissh","Yavanak","Saahi","chuy","batmanbill");
		  
		
		List<String> list1 = Arrays.asList("Krissh","Yavanak","Saahi","chuy","batmanbill","batmanbill");
		System.out.println(list1.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting())));
		System.out.println(list1.stream().collect(Collectors.groupingBy(a->a.toString().toUpperCase(),Collectors.counting())));
		
		List<Integer> intList = Arrays.asList(12,23,1,46,90,6,23,87,8);
		System.out.println(intList.stream().collect(Collectors.summingInt(i->i*2)));
		System.out.println(list1.stream().collect(Collectors.summingLong(i->i.toString().length())));
		System.out.println(list1.stream().collect(Collectors.averagingInt(i->i.toString().length())));
		
		System.out.println(list1.stream().collect(Collectors.counting())+" "+list1.stream().count());
		
		System.out.println(list1.stream().collect(Collectors.joining())+" "+list1.stream().collect(Collectors.joining("- -")));
		
	}
	
	@Test
	public void minAndMax() {
//		int[] A = new int[] {5,3,1,9,6,0};
		Integer[] arr = Arrays.stream(new int[] {5,3,1,9,6,0}).boxed().toArray(Integer[]::new);
		List<Integer> list = Arrays.asList(arr);
		System.out.println(list.stream().sorted().min(Comparator.naturalOrder()).get());
	}
	

}
