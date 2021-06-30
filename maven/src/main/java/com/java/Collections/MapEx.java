package com.java.Collections;

import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.testng.annotations.Test;

public class MapEx {

	@Test
	public void map1() {
//		Map<String, Integer> map = new Hashtable<String, Integer>();
		Map<String, Integer> map = new HashMap<String, Integer>();
		Collections.synchronizedMap(map);
		map.put("A", 1);
		map.put("B", 8);
		map.put("C", 10);
		map.put("D", 2);
		map.put("E", 5);
		
		System.out.println(map);
		
		// generic 
		
		 Set<Entry<String, Integer>> set = map.entrySet();
		 for(Entry<String, Integer> s: set) {
			 System.out.println(s.getKey()+" | "+map.get(s.getKey()));
		 }
		 
		 // New
		 for(Entry<String,Integer> m : map.entrySet()) {
			 System.out.println(m.getKey()+" - "+m.getValue());
		 }
		 
		 // Using lambda
		 map.forEach((k,v)->System.out.println(k+" : "+v));
		 map.entrySet().stream().sorted(Map.Entry.comparingByValue((s1,s2)->s2.compareTo(s1))).forEach(System.out::println);
	}
}
