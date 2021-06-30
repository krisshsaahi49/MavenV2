package com.java.polymorphism;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tiger extends Animal implements NonVegeterian{

	@Test
	public void test() {
		NonVegeterian nv = new Tiger();		// Creating reference variable to Interface
		Animal a = new Tiger();				// Creating reference variable to IS-A class
		NonVegeterian nav = new Animal();
		nv.food();
		a.food();
		food();
		nav.food();
	}
	
	public void food() {
		System.out.println("I will eat vegeterian though I am predator");
	}
	
	@Test
	public void test2() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();	
		driver.get("https://google.com");
	}
}
