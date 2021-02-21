package com.java.Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.ListIterator;

import org.apache.commons.lang3.RandomUtils;
import org.testng.annotations.Test;

public class ArrayListEx {

	@Test
	public void arrList() {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			arr.add(i);
		}

		System.out.println(arr.toString());
		// Iterating using Iterator
		Iterator<Integer> itr = arr.iterator();

		while (itr.hasNext()) {
			System.out.println(itr.next());
		}

		// set an element at index 5
		arr.set(4, 99);
		System.out.println(arr);
	}

	@Test
	public void sortArrayList() {
		ArrayList<Integer> aL = new ArrayList<Integer>();

		for (int i = 0; i < 10; i++) {
			aL.add(RandomUtils.nextInt(1, 100));
		}
		
		System.out.println(aL);
		Collections.sort(aL);
		System.out.println(aL);
	}
	
	@Test
	public void sortListIerator() {
		ArrayList<Integer> aL = new ArrayList<Integer>();

		for (int i = 0; i < 10; i++) {
			aL.add(RandomUtils.nextInt(1, 100));
		}
		
		System.out.println(aL);
		
		ListIterator<Integer> list = aL.listIterator();
		
		while(list.hasNext()) {
			System.out.println(list.next());
		}
		System.out.println("-------------------------------------");
		while(list.hasPrevious()) {
			System.out.println(list.previous());
		}
	}
	
	@Test
	public void sortusingJava8() {
		ArrayList<Integer> aL = new ArrayList<Integer>();

		for (int i = 0; i < 10; i++) {
			aL.add(RandomUtils.nextInt(1, 100));
		}
		
		System.out.println(aL.toString());
		
		aL.forEach(i->System.out.println(i)); 	// Lamda expression 
		System.out.println("-----------------------");
		Iterator<Integer> list = aL.iterator();
		list.forEachRemaining(i->System.out.println(i));			// Iterator and again lamda expression
	}
}
