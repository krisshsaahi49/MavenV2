package com.java8.Streams;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.testng.annotations.Test;

public class PracticePrograms {

//	Java Program to Find the Occurrence of Words in a String using HashMap
	@Test
	public void wordOcuurence() {
		String s = "I am a boy and I am a boy and I am from newyork and from washington";
		Map<String, Long> map = Arrays.stream(s.split("\\s"))
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		map.forEach((k, v) -> System.out.println(k + " " + v));
		
		// Using simple Hashamp
		String[] a = s.split("\\s");
		HashMap<String, Integer> hashmap = new HashMap<String, Integer>();
		for(int i=0;i<a.length;i++) {
			if(hashmap.containsKey(a[i])) {
				int count = hashmap.get(a[i]);
				hashmap.put(a[i], count+1);
			}else {
				hashmap.put(a[i], 1);
			}
		}
		System.out.println(hashmap);
	}

//	Java Program to Add Two Binary Strings
	@Test
	public void binaryAddition() {
		String a = "100";
		String b = "001";

	}

//	Java Program to Convert String to String Array Using Regular Expression
	@Test
	public void strArray() {
		String s = "I am a boy and I am a boy and I am from newyork and from washington";

		String[] a = s.split("\\s");
		Arrays.stream(a).forEach(System.out::println);
	}

	@Test
	public void singleQuoteChar() {
		String s = "hello everyone, my name is 'Krissh saahi'iui&f";
		Pattern pattern = Pattern.compile(".*'(.*)'.*");
		System.out.println(s.matches(".*'(.*)'.*"));
		Matcher m = pattern.matcher(s);

		if (m.matches()) {
			System.out.println(m.group());
		}
	}

	@Test
	public void duplduplicateValluesicateVallues() {
		List<String> list = Arrays.asList("krissh", "Biggie", "Sayra", "chuy", "krissh", "Sayra", "phil", "Biggie",
				"chuy", "ramiro", "jenmy");
		list.stream().filter(i -> Collections.frequency(list, i) > 1).collect(Collectors.toSet())
				.forEach(System.out::println);

		list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
				.forEach((k, v) -> System.out.println(k + " " + v));

	}

	@Test
	public void removeMultipleSpace() {
		String s = "This  is  a halloween                costume  and I     want one";
		s = s.replaceAll("\\s+", " ");
		System.out.println(s);
	}

	@Test
	public void reverserNumber() {
		int number = 1234;
		StringBuilder num = new StringBuilder();
		num.append(String.valueOf(number));
		System.out.println(num.reverse());

		int invert = 0;
		while (number != 0) {
			invert = invert * 10 + number % 10;
			number = number / 10;
		}

		System.out.println("Using Int : " + invert);
	}

	@Test
	public void checkPrimeNumber() {
		int num = 3;
		int flag = 0;
		if (num == 0 || num == 1) {
			System.out.println("Not a prime number");
			flag = 1;
		} else {
			for (int i = 2; i < Math.sqrt(num); i++) {
				if (num % i == 0) {
					System.out.println("Not a prime number");
					flag = 1;
					break;
				}
			}
		}
		if (flag == 0) {
			System.out.println("Prime number");
		}
	}

	@Test
	public void printAllPrimeNumber() {}
	
	@Test
	public void swapVariableswithoutTemp() {
		int numX = 10;
		int numY = 20;
		System.out.println("Pre-swapping state:");
		System.out.println("numX value: " + numX);
		System.out.println("numY value: " + numY);
		
		System.out.println("");
		
		numX = numX + numY;
		numY = numX - numY;
		numX = numX - numY;
		System.out.println("Post-swapping state:");
		System.out.println("numX value: " + numX);
		System.out.println("numY value: " + numY);
	}
	
	String getUniqueCharacterSubstring(String input) {
	    Map<Character, Integer> visited = new HashMap<>();
	    String output = "";
	    for (int start = 0, end = 0; end < input.length(); end++) {
	        char currChar = input.charAt(end);
	        if (visited.containsKey(currChar)) {
	            start = Math.max(visited.get(currChar)+1, start);
	        }
	        if (output.length() < end - start + 1) {
	            output = input.substring(start, end + 1);
	        }
	        visited.put(currChar, end);
	    }
	    return output;
	}
	
	@Test
	public void longestSubString() {
		
		System.out.println(getUniqueCharacterSubstring("always be codingE"));
	}
	
	@Test
	public void occurenceOfCharInString() {
		String s = "Hello dude my name is krishna saahi";
		String[] arr = s.split("");
		Map<String, Long> str = Arrays.asList(arr).stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		System.out.println(str);
	} 
	
	@Test
	public void sort() {
		int[] arr = new int[] {89,45,11,53,90,7,35,87,22};
		Arrays.stream(arr).sorted().forEach(System.out::println);
		
		// COnverting int[] to Inetegr[]
		Integer[] arrInt = Arrays.stream(arr).boxed().toArray(Integer[]::new);
		
		List<Integer> collectionEx = Arrays.asList(arrInt);
		// using sorted and compartor
		Arrays.asList(arrInt).stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
		Arrays.asList(arrInt).stream().sorted().forEach(System.out::println);
		
		// Sorting using lamda expression
		System.out.println("Sorted and Lambda");
		Arrays.asList(arrInt).stream().sorted((a,b)->a.compareTo(b)).forEach(System.out::println);
		Arrays.asList(arrInt).stream().sorted((a,b)->b.compareTo(a)).forEach(System.out::println);
		
		
		// Using collections sort
		System.out.println("Using Collections.sort");
		Collections.sort(collectionEx,(a,b)-> {return b-a;});
		System.out.println(collectionEx);
		Collections.sort(collectionEx,(a,b)-> {return a-b;});
		System.out.println(collectionEx);
	}
}

