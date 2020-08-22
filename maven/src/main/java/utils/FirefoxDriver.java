package utils;

import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirefoxDriver implements GetDriver {
	
	@Override
	public WebDriver startDriver(WebDriver driver) {
		// TODO Auto-generated method stub
		WebDriverManager.firefoxdriver().setup();
		driver = new org.openqa.selenium.firefox.FirefoxDriver();
		return driver;
	}

}
