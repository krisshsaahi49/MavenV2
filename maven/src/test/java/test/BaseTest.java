package test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

	@BeforeMethod
	public void setup() {
	
		DriverFactory.getInstance().setDriver((new BrowserFactory()).createDriver("chrome"));
	}
	
	@AfterMethod
	public void teardown() {
		DriverFactory.getInstance().closeBrowser();
	}
}
