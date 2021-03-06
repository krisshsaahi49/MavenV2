package com.apache.ApachePoi;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExcelRead3 {
	public static WebDriver driver;
	public String BROWSER="CHROME";  
	
	
	@BeforeTest
	@Parameters("browser")
	public void setUp(String browser){
		
		BROWSER=browser;

		if (BROWSER.equals("GC")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("start-maximized");
			options.setHeadless(false);
			driver = new ChromeDriver(options);
		}else if(BROWSER.equals("FF")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}else if(BROWSER.equals("IE")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}else if(BROWSER.equals("MOBILE")) {
			WebDriverManager.chromedriver().setup();
			Map<String, Object> deviceMetrics = new HashMap<String, Object>();
			deviceMetrics.put("width", 414);
			deviceMetrics.put("height", 736);
			deviceMetrics.put("pixelRatio", 4.0);
			Map<String, Object> mobileEmulation = new HashMap<String, Object>();
			mobileEmulation.put("deviceMetrics", deviceMetrics);
			mobileEmulation.put("userAgent",
					"Mozilla/5.0 (iPhone; CPU iPhone OS 12_0 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) FxiOS/13.2b11866 Mobile/16A366 Safari/605.1.15");
			Map<String, Object> chromeOptions = new HashMap<String, Object>();
			chromeOptions.put("mobileEmulation", mobileEmulation);
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
			driver = new ChromeDriver(capabilities);
		}

	
	}
	
	@Test
	public void login() {
		driver.get("https://bing.com");
		System.out.println("Page ttile " + driver.getTitle()+"  -  "+BROWSER);
		Reporter.log("Page ttile " + driver.getTitle()+"  -  "+BROWSER);

		driver.get("https://google.com");
		System.out.println("Page ttile " + driver.getTitle()+"  -  "+BROWSER);
		Reporter.log("Page ttile " + driver.getTitle()+"  -  "+BROWSER);
	
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}

	/*
	 * @AfterSuite public void tearDown() { // driver.close(); driver.quit(); }
	 */
}
