package com.java.Parametrization;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterizationGarbage {
	/*
	 * @Parameters({"myName","myAge"})
	 * 
	 * @Test public void params(@Optional("Krishna Saahi") String
	 * name, @Optional("25") int age) {
	 * System.out.println("My name is "+name+" | "+"Age "+age); }
	 */
	
	// Passsing paramters from properties file and listeners
	// Ref https://stackoverflow.com/questions/46224926/set-properties-file-to-testng-xml
	
	@Parameters({"Myname","driver.chrome","chrome.path"})
	@Test
	public void paramPropertieFile(String name, String browser, String path) {
		System.out.println(name+ " | "+browser+" | "+path);
	}
}
