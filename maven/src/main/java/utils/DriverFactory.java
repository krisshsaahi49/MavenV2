package utils;

import org.openqa.selenium.WebDriver;

public class DriverFactory {

	public enum BROWSER {
		CHROME, FIREFOX;
	}

	public static GetDriver getDriver(BROWSER browser) {
		switch (browser) {
		case CHROME:
			return new ChromeDriver();
		case FIREFOX:
			return new FirefoxDriver();
		default:
			System.out.println("No broswwer found");
			break;
		}
		return null;
	}
}
