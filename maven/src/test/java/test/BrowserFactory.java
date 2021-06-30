package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {

	public WebDriver driver;

	public WebDriver createDriver(String browser) {
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized");
			options.addArguments("--incognito");
			driver = new ChromeDriver(options);
		}else if(browser.equalsIgnoreCase("firefox")) {

		}
		return driver;
	}
}
