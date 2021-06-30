package com.java.practice.qaJavaPrograms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.testng.annotations.Test;

import com.java.Collections.Collections;

public class Practice1 {

	/*
	 * Java heap and java stack java stack - threads,primitive variables and
	 * reference to heap objects ref :
	 * https://www.journaldev.com/4098/java-heap-space-vs-stack-memory java heap -
	 * objects
	 */
	@Test
	public void javaMemoryTypes() {
		int i = 9; // stored at statck
		Practice1 p = new Practice1(); // object stored at java heap
		p.sup();
	}

	void sup() {
		String s = "Hello"; // String literal stored at string pool which is again part of java heap
		System.out.println(s);
	}

	// Stringpool java - ref :
	// https://www.edureka.co/blog/java-string-pool/#:~:text=String%20Pool%20is%20a%20storage%20area%20in%20Java%20heap.&text=To%20decrease%20the%20number%20of,the%20string%20literal%20pool%20first.
	@Test
	public void stringPool() {
		String s1 = "krissh"; // String literal - creates a new object in stringpool initially
		String s2 = "krissh"; // Checks string pool for object if yes - create a reference to it else create a
		// new object in string pool
		String s3 = new String("krissh"); // String new keyword creates a new object in string pool, doesnt even check
		// if the object exists or not..so dumb!
		String s4 = new String("krissh");
		s4.intern(); // intern method add the object to the string pool

		System.out.println(s1 == s2); // true because s1 and s2 are string literals and have same refernce to the
		// object krissh
		System.out.println(s1 == s3); // false because s1 and s3 are completely different objects
		System.out.println(s1 == s4.intern()); // true because s4 is added to stringpool using string intern method
	}

	// Java Program to count the total number of characters in a string
	@Test
	public void printCharacters() {
		String name = "oracle india private limited";
		String[] names = name.split("");
		// using java8 streams
		Arrays.asList(names).stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
				.forEach((k, v) -> System.out.println(k + " " + v));

		// using hasmap
		Map<String, Integer> countCharacters = new HashMap<String, Integer>();

		int count = 1;
		for (String a : names) {
			if (countCharacters.containsKey(a)) {
				countCharacters.put(a, countCharacters.get(a) + 1);
			} else {
				countCharacters.put(a, count);
			}
		}

		for (Entry<String, Integer> a : countCharacters.entrySet()) {
			System.out.println(a.getKey() + " " + a.getValue());
		}
	}

	// Java Program to count the total number of punctuation characters exists in a
	// String

	@Test
	public void printPunctuationChar() {
		String s = " Hello! I'm a pleas???ant person. what's that? i hea!rd, u were dead. ";
		String[] name = s.replaceAll(" ", "").split("");
//		Arrays.asList(name).stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting())).forEach((k,v)->System.out.println(k+" "+v));
		Map<String, Integer> map = new HashMap<String, Integer>();
		int count = 1;

		for (String a : name) {

			if (a.contains(".") || a.contains(",") || a.contains("!") || a.contains("?") || a.contains("\'")) {

				if (map.containsKey(a)) {
					map.put(a, map.get(a) + 1);
				} else {
					map.put(a, count);
				}
			}
		}

		map.forEach((k, v) -> System.out.println(k + " " + v));

	}

	@Test
	public void noOfVowelsAndConstants() {
		String s = " Hello! I'm a pleas???ant person. what's that? i hea!rd, uuuu were dead. ";
		String[] name = s.toLowerCase().replaceAll(" ", "").split("");

		Map<String, Long> map = Arrays.asList(name).stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
//		map.forEach((k,v)->System.out.println(k+" "+v));
		// To print vowels
		map.entrySet().stream()
				.filter(a -> a.getKey().contains("a") || a.getKey().contains("e") || a.getKey().contains("i")
						|| a.getKey().contains("o") || a.getKey().contains("u"))
				.forEach(k -> System.out.println(k.getKey() + " " + k.getValue()));

		// to print constants
		map.entrySet().stream()
				.filter(a -> !a.getKey().contains("a") || !a.getKey().contains("e") || !a.getKey().contains("i")
						|| !!a.getKey().contains("o") || !!a.getKey().contains("u") || !a.getKey().contains(".") || !a.getKey().contains(",")
						|| !a.getKey().contains("!") || !a.getKey().contains("?") || !a.getKey().contains("\'"))
				.forEach(k -> System.out.println(k.getKey() + " " + k.getValue()));
	}
	
	@Test
	public void extractNumberFromString() {     
		String s = "Abss410shj232h983126";
		StringBuilder num = new StringBuilder();
		StringBuilder str = new StringBuilder();
		for(String s1 : s.split("")) {
			if(s1.contains("0") || s1.contains("1") || s1.contains("2") || s1.contains("3") ||
					s1.contains("4") || s1.contains("5") || s1.contains("6") || s1.contains("7") ||
					s1.contains("8") || s1.contains("9")) {
				num.append(s1);
			}else {
				str.append(s1);
			}
		}
		
		System.out.println(num+"  "+str);
		
		// Method 2
		List<String> numList = Arrays.asList("0","1","2","3","4","5","6","7","8","9");
		System.out.println(numList);
		
		for(String s1 : s.split("")) {
			if(numList.contains(s1)) {
				System.out.print(s1+" ");
			}
		}

	}
	
	@Test
	public void regex() {
		Pattern pattern = Pattern.compile("aah",Pattern.CASE_INSENSITIVE);
		Matcher match = pattern.matcher("KRISHNASAAHIYAVANA");
		System.out.println(match.find());
		
		Matcher match1 = Pattern.compile("hello", Pattern.CASE_INSENSITIVE).matcher("HellomynameisHELLOandIdonnnohElLo");
		System.out.println(match1.find()+" | "+match1.end());
		System.out.println(Pattern.matches("hello", "ahtywodhellohdhadshello"));
		
		// printing character using ASCII value
		for(int i=0;i<26;i++) {
			System.out.print(Character.toString(65+i));
		}
		System.out.println("\n");
		
		while(match1.find()) {
			System.out.println(match1.group());
		}
		
		System.out.println("---------other regex patterns -----------");
		System.out.println(Pattern.matches("...as", "Kmmas"));
		System.out.println(Pattern.matches("[^abc]{3}", "fgd"));  
		System.out.println(Pattern.matches("[[a-d][w-z][e-k]]", "g"));  
		System.out.println(Pattern.matches("[[a-z]&&[^d-k]]", "w"));  
		System.out.println(Pattern.matches("kri(.*)shna", "kriiiiiiiiiiiiisshna"));
		System.out.println(Pattern.matches(".*hope*", "qwertyuiopasahgjhdhopeeeeeeee"));
		System.out.println(Pattern.matches("(.*)(hope|pope|krissh){1}", "qwertyuiopasahgjhdhopekrisshkrissh"));
		
		System.out.println("-----meta characcter ----------");
		System.out.println(Pattern.matches("\\d", "1"));
		System.out.println(Pattern.matches("\\d", "?"));
		System.out.println(Pattern.matches("\\d", "A"));
		System.out.println(Pattern.matches("\\D", "?"));
		System.out.println(Pattern.matches("\\D", "N"));
		System.out.println(Pattern.matches("\\w", "?"));
		System.out.println(Pattern.matches("\\w", "A"));
		System.out.println(Pattern.matches("\\w", "0"));  // \\w - [a-zA-Z0-9]
		System.out.println(Pattern.matches("\\W", "?"));
		System.out.println(Pattern.matches("[^\\W\\s\\d]", "a"));
		System.out.println(Pattern.matches("[[\\w]&&[^\\d]]", "_"));
		
		System.out.println("---------- SPECIAL CHARACTERS -----------");
		String s = "T_h?is i!s1 a 2s_amp-l3e str:i4n;g";
		String[] s1 =  s.split("\\W");
		Arrays.asList(s1).stream().forEach(a->System.out.println(a));
		System.out.println("---------- DIGITS -----------");
		String[] s2 =  s.split("\\d");
		Arrays.asList(s2).stream().forEach(a->System.out.println(a));
		System.out.println("---------- EXTRACITNG NUMBERS FROM STRING USING REGEX -----------");
		String[] s3 =  s.split("\\D");
		Arrays.asList(s3).stream().filter(a->a.matches("\\d")).forEach(System.out::println);
	}
	
	@Test
	public void regexExtractStringfromSignleQuotes() {
		System.out.println("-------EXTRCT STRING BETWEEN QUOTES----------");
		String mydata = "some string with 'the data i want' 'inside' and 'gonna test' some of the 'ample amount of data' and it's goone";
		Pattern p = Pattern.compile("'(.*?)'");
		Matcher m = p.matcher(mydata);
		while (m.find()) {
		  System.out.println(m.group(1));
		}
		// using java8 and stream
		System.out.println("------------USING JAVA8 AND STREAMS --------");
		p.matcher(mydata).results().map(a->a.group(1)).forEach(System.out::println);
		
		System.out.println("-------EXTRCT NUMBERS BETWEEN STRING----------");
		String a = "123hell465ob678ye789";
		Pattern pattern = Pattern.compile("\\D(\\d+)\\D");
		pattern.matcher(a).results().map(b->b.group(1)).forEach(System.err::println);
	}
	
	@Test
	public static void waitWithoutThreadsleep() {
//		ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
//		service.schedule(Runnable, 2, TimeUnit.SECONDS);
		
				
	}
	
	@Test
	public void anagram() {
		String s1 = "listen";
		String s2 = "silent";
		
		String[] s3 = s1.split("");	
		String[] s4 = s2.split("");
		System.out.println("---------------");
		
		for(String a : s4) {
			System.out.println(a);
		}
		
		System.out.println(Arrays.equals(s3, s4));
		
	}
	
	@Test
	public void primeNumbers() {
		int num =19;
		int count =0;
		for(int i=2;i<=num;i++) {
			for(int j=2;j<=i;j++) {
				if(i!=j) {
					if(i%j==0) {
						count++;
						break;
					}else {
						System.out.println(i);
						break;
					}
				}
			}
		}
	}
	
	@Test
	public void maxCovergagePokeType() {
		Map<String,Set<String>> type = new HashMap<String, Set<String>>();
		type.put("Grass", new HashSet<String>(Arrays.asList("Ground, Rock, Water")));
		type.put("Bug", new HashSet<String>(Arrays.asList("Grass, Dark, Psychic")));
		type.put("Dark", new HashSet<String>(Arrays.asList("Ghost, Psychic")));
		type.put("Ghost", new HashSet<String>(Arrays.asList("Ghost, Psychic")));
		type.put("Electric", new HashSet<String>(Arrays.asList("Flying, Water")));
		type.put("Water", new HashSet<String>(Arrays.asList("Fire, Ground, Rock")));
		
		type.put("Psychic", new HashSet<String>(Arrays.asList("Fighting, Poison")));
		type.put("Fairy", new HashSet<String>(Arrays.asList("Fighting, Dark, Dragon")));
		type.put("Steel", new HashSet<String>(Arrays.asList("Fairy, Ice, Rock")));
		type.put("Poison", new HashSet<String>(Arrays.asList("Fairy, Grass")));
		type.put("Ground", new HashSet<String>(Arrays.asList("Electric, Fire, Poison, Rock, Steel")));
		type.put("Ice", new HashSet<String>(Arrays.asList("Dragon, Flying, Grass, Ground")));
		
		type.put("Dragon", new HashSet<String>(Arrays.asList("Dragon")));
		type.put("Fighting", new HashSet<String>(Arrays.asList("Dark, Ice, Normal, Rock, Steel")));
		type.put("Fire", new HashSet<String>(Arrays.asList("Bug, Grass, Ice, Steel")));
		type.put("Rock", new HashSet<String>(Arrays.asList("Bug, Fire, Flying, Ice")));
		type.put("Flying", new HashSet<String>(Arrays.asList("Bug, Fighting, Grass")));
		type.put("Normal", new HashSet<String>(Arrays.asList("Normal")));
		
		System.out.println(type.get("Grass"));
		
	}
	
}
