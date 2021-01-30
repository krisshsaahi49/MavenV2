package com.TestngListners.ITestListner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(ListenersBlog.class) // Class level Listners
public class ListnersTests {
	public WebDriver driver;

	{
		System.out.println("Static block");
	}
	public ListnersTests() {
		System.out.println("Constructor");
	}

	@BeforeClass
	public void beforeClass() {
		System.err.println("Before class");
		/*
		 * WebDriverManager.chromedriver().setup(); driver = new ChromeDriver();
		 */
	}

	@BeforeMethod
	public void beforeMethod() {
		System.err.println("Before method");
		/*
		 * WebDriverManager.firefoxdriver().setup(); driver = new FirefoxDriver();
		 */

	}

	@BeforeTest
	public void beforeTest() {
		System.err.println("Before Test");
		/*
		 * WebDriverManager.iedriver().setup(); driver = new InternetExplorerDriver();
		 */
	}

	@BeforeSuite
	public void beforeSuite() {
		System.err.println("Before Test");
	}

	@Test // Passing Test
	public void sampleTest1() throws InterruptedException {
		driver.manage().window().maximize();
		driver.get("https://www.apple.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@id=\'ac-globalnav\']/div/ul[2]/li[3]")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#chapternav > div > ul > li.chapternav-item.chapternav-item-ipad-air > a"))
				.click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Why iPad")).click();
		Thread.sleep(2000);
		driver.quit();
	}

	@Test // Failing Test
	public void sampleTest2() throws InterruptedException {
		System.out.println("Forcely Failed Test Method");
		Assert.assertTrue(false);
	}

	private int i = 0;

	@Test(successPercentage = 60, invocationCount = 5) // Test Failing But Within Success Percentage
	public void sampleTest3() {
		i++;
		System.out.println("Test Failed But Within Success Percentage Test Method, invocation count: " + i);
		if (i == 1 || i == 2) {
			System.out.println("sampleTest3 Failed");
			Assert.assertEquals(i, 6);
		}
	}

	@Test // Skipping Test
	public void sampleTest4() {
		throw new SkipException("Forcely skipping the sampleTest4");
	}

	@AfterClass
	public void afterClass() {
		System.err.println("After class");
	}

	@AfterMethod
	public void afterMethod() {
		System.err.println("After method");
	}

	@AfterTest
	public void afterTest() {
		System.err.println("Before Test");
	}

	@AfterSuite
	public void afterSuite() {
		System.err.println("Before Test");
	}
}