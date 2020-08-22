package com.java8;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class CollectionsSorting {

	public static void main(String args[]) {
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(6);
		a.add(10);
		a.add(26);
		a.add(8);
		a.add(1);
		a.add(90);
		
		/*
		 * compare() method working: – returns negative value(-1), if and only if obj1
		 * has to come before obj2. returns positive value(+1), if and only if obj1 has
		 * to come after obj2. returns zero(0), if and only if obj1 and obj2 are equal.
		 */
		
		Collections.sort(a, (a1,a2) -> (a1<a2) ? -1 : (a1>a2) ? 1 : 0);
		System.out.println(a);
	}
}
