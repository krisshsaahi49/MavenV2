package com.java.Collections;

import java.util.ArrayList;

import org.testng.annotations.Test;

public class Collections {
	
	String index,value;

	public Collections(String index, String value) {
		this.index = index;
		this.value = value;
	}
	
	public boolean equals(Object o) {
		Collections c = (Collections) o;
		return value.equalsIgnoreCase(c.value);
	}
	
	@Test
	public static void test() {
		Collections c1 = new Collections("x","Hello");
		Collections c2 = new Collections("y","Hello");
		Collections c3 = new Collections("z","Hello");
		ArrayList<Collections> o = new ArrayList<Collections>();
		o.add(c1);o.add(c2);o.add(c3);
		o.remove(c3);
		for(Collections obj : o) {
			System.out.println(obj.index+" "+obj.value);
		}
	}
}
