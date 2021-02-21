package com.selenium.DesiredCapability;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DesiredCapability2 {
	
	public static RemoteWebDriver driver;
	
	@BeforeClass
	public void setUp() throws Exception {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("browserName", "chrome");
		capabilities.setCapability("version", "77.0");
		capabilities.setCapability("platform", "win10"); // If this cap isn't specified, it will just get any available
															// one
		capabilities.setCapability("build", "LambdaTestSampleApp");
		capabilities.setCapability("name", "LambdaTestJavaSample");
		capabilities.setCapability("network", true); // To enable network logs
		capabilities.setCapability("visual", true); // To enable step by step screenshot
		capabilities.setCapability("video", true); // To enable video recording
		capabilities.setCapability("console", true); // To capture console logs

		capabilities.setCapability("selenium_version", "4.0.0-alpha-2");
		capabilities.setCapability("timezone", "UTC+05:30");
		capabilities.setCapability("geoLocation", "IN");
		capabilities.setCapability("chrome.driver", "78.0");
		try {
			driver = new RemoteWebDriver(new URL("https://google.com"), capabilities);
		} catch (MalformedURLException e) {
			System.out.println("Invalid grid URL");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
	
	@Test
	public void test1() {
		
	}
}
