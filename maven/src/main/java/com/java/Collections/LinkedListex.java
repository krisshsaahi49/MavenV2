package com.java.Collections;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

import org.apache.commons.lang3.RandomUtils;
import org.testng.annotations.Test;

public class LinkedListex {

	@Test
	public void ex1() {
		LinkedList<Integer> linkedLlist = new LinkedList<Integer>();
		
		for(int i=0;i<5;i++) {
			linkedLlist.add(RandomUtils.nextInt(1,100));
		}
		
		System.out.println(linkedLlist);
		
		Iterator<Integer> l = linkedLlist.descendingIterator();
		
		Collections.sort(linkedLlist);
		Collections.reverse(linkedLlist);
		
		System.out.println(linkedLlist);
		
		System.out.println(linkedLlist.peek()+" "+linkedLlist.get(3));
	}
}
