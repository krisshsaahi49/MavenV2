package garbage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import lib.Wait;
import utils.DriverFactory;
import utils.DriverFactory.BROWSER;
import utils.GetDriver;

public class Test5 {

	WebDriver driver;

	@BeforeMethod
	public void startBrowser() {
		GetDriver getDriver = DriverFactory.getDriver(BROWSER.FIREFOX,driver);
		driver = getDriver.startDriver();
	}

	@Test
	public void navigateGoogle() {
		
		driver.get("https://google.com");
	}
	
	@Test
	public void navigateBing() {

		driver.get("https://bing.com");
		Wait.waitForJSandJQueryToLoad(driver);
		
	}

	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}
}
