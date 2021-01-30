package utils;

import org.openqa.selenium.WebDriver;

public class DriverFactory {

	public enum BROWSER {
		CHROME, FIREFOX;
	}

	public static GetDriver getDriver(BROWSER browser,WebDriver driver) {
		switch (browser) {
		case CHROME:
			return new ChromeDriverTest(driver);
		case FIREFOX:
			return new FirefoxDriver(driver);
		default:
			System.out.println("No broswwer found");
			break;
		}
		return null;
	}
}
