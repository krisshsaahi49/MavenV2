package testAutomation.POM.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;
import testAutomation.POM.pages.LoginPageFactory;

public class BaseTest {
	
	LoginPageFactory factory;
	WebDriver driver;

	@BeforeSuite
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		factory = new LoginPageFactory(driver);

		driver.get("http://demo.guru99.com/V4/");
	}
	
	@AfterSuite
	public void tearDown() {
		driver.quit();
	}
}

