  package com.java.files;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.testng.annotations.Test;

public class FileExample2 {

	@Test			// using buffered wirter
	public void writeFile() throws IOException {
		BufferedWriter reader = new BufferedWriter(new FileWriter("abc.txt"));
		reader.write("This is a sample from Buffered writer \n I love using it \n ciao");
		reader.flush();reader.close();
	}
	
	@Test
	public void readFile() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader("abc.txt"));
		String line = reader.readLine();
		StringBuilder readText = new StringBuilder();
		while(line!=null) {
			readText.append(line);
			line = reader.readLine();
		}
		
		System.out.println(readText.toString());
		reader.close();
	}
	
	@Test
	public void getRecurgetRecurringWordsringWords() throws IOException {
		BufferedReader reader  = new BufferedReader(new FileReader("Hello.txt"));
		String line = reader.readLine();
		StringBuilder str = new StringBuilder();
		while(reader.readLine()!=null) {
			str.append(line);
			line = reader.readLine();
		}
		
		System.out.println(str.toString());
		Map<String, Integer> map = new HashMap<String, Integer>();
		String[] s = str.toString().split("\\s");
		for(String s1 : s) {
			map.put(s1, java.util.Collections.frequency(Arrays.asList(s), s1));
		}
		
		System.out.println(map);
		
		 Entry<String, Integer> a = map.entrySet().stream().max((a1,a2)-> a1.getValue().compareTo(a2.getValue())).get();
		 
		
	}
}
