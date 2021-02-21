package com.java.corePlatform.Strings;

import java.util.StringJoiner;

import org.testng.annotations.Test;

public class StringJoinner {

	@Test
	public void ex1() {
		StringJoiner str = new StringJoiner(". ");
		str.add("alpha").add("beta").add("gamma");
		System.out.println(str.toString());
	}
	
	@Test
	public void ex2() {
		StringJoiner str = new StringJoiner(", ","(", ")");
		str.add("alpha").add("beta").add("gamma");
		System.out.println(str.toString());
	}
	
	@Test
	public void ex3() {
		StringJoiner str = new StringJoiner("), ( ","{(", ")}");
		str.add("alpha").add("beta").add("gamma");
		System.out.println(str.toString());
	}
	
	@Test
	public void ex4() {
		StringJoiner str = new StringJoiner(", ");
		str.setEmptyValue("NULL");
		str.add("KRISSH");
		System.out.println(str.toString());
		if(str.toString().isEmpty()) {
			System.out.println("EMPTY STRING");
		}else {
			System.out.println("BOOO IT'S NOT EMPTY"+str.toString());
		}
	}
	
	@Test
	public void ex5() {
		String str = String.format("%.4f", 100.12);
		System.out.println(str);
	}
}
