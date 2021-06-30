package testAutomation.POM.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import testAutomation.POM.pages.LoginPageFactory;

public class GuruLoginFactory extends BaseTest{
	
	
	@Test
	public void login() {
//		factory = new LoginPageFactory(driver);
		factory.Login();

	}
	
	
}