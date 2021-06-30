 package com.java8.Streams;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.annotations.Test;

public class Stream1 {

	@Test
	public void test1() {
		List<String> names = Arrays.asList("ali", "Sayra", "Biggie", "Julian", "Batman", "vee", "phillie", "krissh",
				"shadow");
		names.forEach(s -> System.out.println(s)); // printing with regualr lamda
		names.forEach(System.out::println); // printing with method reference
		names.stream().forEachOrdered(s -> System.out.println(s)); // using streams
		System.out.println("*********** starting with B ************");
		names.stream().map(s -> s.replace("ali", "pollo")).filter(s -> s.toUpperCase().startsWith("B"))
				.forEach(System.out::println);
		System.out.println("************ Generating Random numbers with stream *************");
		Stream<Integer> randomNumbers = Stream.generate(() -> (new Random()).nextInt(100));

		randomNumbers.limit(20).forEach(System.out::println);
		Stream<Double> x =  Stream.generate(()->(new Random()).nextDouble());
		List<Double> db = x.limit(5).collect(Collectors.toList());
		System.out.println(db);
		
		 
        Stream<String> stream = Stream.of("A$B$C".split("\\$"));
        stream.forEach(p -> System.out.println(p));
	}
	
	@Test
	public void test2() {
		List<String> names = Arrays.asList("ali", "Sayra", "Biggie", "Julian", "Batman", "vee", "phillie", "krissh",
				"shadow");
		System.out.println(names.stream().collect(Collectors.joining()));
		System.out.println(names.stream().collect(Collectors.joining("-")));
	}
	
	@Test
	public void wordCounter() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader("Hello.txt"));
		String line = reader.readLine();
		StringBuilder sb = new StringBuilder();
		while(line!=null) {
			sb.append(line);
			line = reader.readLine();
		}
		List<String> wordsList = Arrays.asList(sb.toString().replace(".","").replace(",","").split("\\s"));
		
		Map<String, Long> collect = 
		        wordsList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		
		System.out.println(collect);
	}
}
