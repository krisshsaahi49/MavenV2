package com.java.ObjectCreation;

import org.testng.annotations.Test;

public class WaysToCreateObject {
	
	int i=10;
	
	@Test
	public void usingNewKeyword() {
		BaseClass b = new BaseClass();
		b.s1 = "New ....";	// Override s1 in Baseclass
		b.display();
		WaysToCreateObject ways = new WaysToCreateObject();
	}
	
	public WaysToCreateObject() {
		BaseClass w = new BaseClass();
		System.out.println(w.s1);
	}
}
