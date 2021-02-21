package com.selenium.DesiredCapability;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DesiredCapability {
	
	public static WebDriver driver;

	@Test  // using chrome options
	public void desCap1() {
		WebDriverManager.chromedriver().browserVersion("88").setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized","disable-infobars","incognito","disable-popup-blocking");
		options.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, true);
		options.setHeadless(true);
		driver = new ChromeDriver(options);
		driver.navigate().to("https://amazon.com");
		System.out.println(options.getVersion()+" "+options.getBrowserName());
	}
	
	@Test  // using chrome options
	public void desCap2() {
		WebDriverManager.iedriver().setup();
		DesiredCapabilities cap = DesiredCapabilities.internetExplorer();
		cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		cap.setCapability(CapabilityType.VERSION, true);
		
		InternetExplorerOptions options = new InternetExplorerOptions();
		options.ignoreZoomSettings();
		
		driver = new InternetExplorerDriver(cap);
				
		driver.navigate().to("https://amazon.com");
		
	}
}
