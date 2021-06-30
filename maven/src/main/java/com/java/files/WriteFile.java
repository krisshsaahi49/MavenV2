package com.java.files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.annotations.Test;

public class WriteFile {

	@Test
	public void writeFile() throws IOException {
		File file = new File("Hello.txt");
		OutputStream output = new FileOutputStream(file);
		String text = "I am writing something..\n hello \n I am writing something everyone know \n and I am a good boy";
		output.write(text.getBytes());
		output.close();
	}
	
	@Test
	public void readFile() throws IOException  {
		File file = new File("Hello.txt");
		BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
		String line = input.readLine();
		while(line!=null) {
			System.out.println(line);
			line = input.readLine();
		}
		input.close();
		System.out.println(file.getAbsolutePath()+" "+file.getCanonicalPath()+" "+file.getPath());
	}
	
	@Test
	public void getIDK() throws IOException {
		
		File file = new File("Hello.txt");
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String line = reader.readLine();
		StringBuilder sb = new StringBuilder();
		while(line!=null) {
			sb.append(line);
			line = reader.readLine();
		}
		
		System.out.println(sb);
		
		String[] s = sb.toString().split("\\s");
		System.out.println(s.length);
		for(String s1 : s) {
			System.out.println(s1);
		}  
	
		List<String> arr = new ArrayList<String>(Arrays.asList(s));
		System.out.println(Collections.frequency(arr, "am"));
		
		Stream<String> distinct = arr.stream().distinct();
//		System.out.println(distinct.count()+" "+arr.size());
		
		List<String> dis = distinct.collect(Collectors.toList());
		distinct.close();
		for(String s1 : arr) {
			System.out.println(s1+ " - "+Collections.frequency(arr, s1));
		}
		
		System.out.println("************** Using Maps ****************");
		
		Map<String ,Long > map = arr.stream()
	            .collect(  Collectors.groupingBy(c ->c , Collectors.counting())         ) ;


	    map.forEach(   (k , v ) -> System.out.println( k + " : "+ v ));
	}
}
