package utils;

import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirefoxDriver implements GetDriver {
	WebDriver driver;

	public FirefoxDriver(WebDriver driver) {
		this.driver = driver;
	}

	@Override
	public WebDriver startDriver() {
		// TODO Auto-generated method stub
		WebDriverManager.firefoxdriver().setup();
		driver = new org.openqa.selenium.firefox.FirefoxDriver();
		return driver;
	}

}
