package testAutomation.POM.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import testAutomation.POM.pages.LoginPageFactory;

public class GuruLoginFactory {

	WebDriver driver;
	LoginPageFactory factory;
	
	@BeforeSuite
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		factory = new LoginPageFactory(driver);

		driver.get("http://demo.guru99.com/V4/");
	}
	
	@Test
	public void login() {
//		factory = new LoginPageFactory(driver);
		factory.Login();

	}
	
	@AfterSuite
	public void tearDown() {
		driver.quit();
	}
}
