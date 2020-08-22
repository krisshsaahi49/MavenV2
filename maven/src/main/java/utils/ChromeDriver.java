package utils;

import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeDriver implements GetDriver {

	@Override
	public WebDriver startDriver(WebDriver driver) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriverManager.chromedriver().clearCache();
		driver = new org.openqa.selenium.chrome.ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		return driver;
	}

}
