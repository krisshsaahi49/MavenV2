package test;

import org.openqa.selenium.WebDriver;

public class DriverFactory {

	public static DriverFactory instance;
	public ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

	private DriverFactory() {
		// TODO Auto-generated constructor stub
	}
	
	public static DriverFactory getInstance() {
		if(instance==null) {
			instance = new DriverFactory();
			synchronized (DriverFactory.class) {
				if(instance==null) {
					instance = new DriverFactory();
				}
			}
		}
		return  instance;
	}
	
	public WebDriver getDriver() {
		return driver.get();
	}

	public void setDriver(WebDriver driver) {
		this.driver.set(driver);
	}
	
	public void closeBrowser() {
		driver.get().quit();
	}
	
}
