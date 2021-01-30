package com.TestngListners.ITestListner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ListenersBlog implements ITestListener {
	public WebDriver driver;
//	2
	public void onTestStart(ITestResult result) {
		System.out.println("New Test Started" + result.getName());
	}

//	3
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test Successfully Finished" + result.getName());
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("Test Failed" + result.getName());
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("Test Skipped" + result.getName());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("Test Failed but within success percentage" + result.getName());
	}

//	1
	public void onStart(ITestContext context) {
		System.out.println("This is onStart method" + context.getOutputDirectory());
		System.out.println(context.getHost());
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
	}

//	last
	public void onFinish(ITestContext context) {
		System.out.println("This is onFinish method" + context.getPassedTests());
		System.out.println("This is onFinish method" + context.getFailedTests());
		System.out.println("*************************************************");
	}
}