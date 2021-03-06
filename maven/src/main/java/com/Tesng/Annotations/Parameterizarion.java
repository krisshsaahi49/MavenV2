package com.Tesng.Annotations;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Parameterizarion {

	@Test
	@Parameters({"name","age","birthPlace"})
	public void param1(String name, String age,String birthPlace) {
		System.out.println(name+"  |  "+age+"  |  "+birthPlace);
	}
	
	
	@Test
	@Parameters({"name","age","birthPlace"})
	public void param2(String name, String age,String birthPlace) {
		System.out.println(name+"  |  "+age+"  |  "+birthPlace);
	}
}
