package navigate;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;

import lib.Wait;

public class NavigateUsingPropertiesFile {
	WebDriver driver;
	
	@org.testng.annotations.Test
	public void chrome() throws InterruptedException, FileNotFoundException, IOException {
		Properties prop = new Properties();
        prop.load(new FileInputStream("application.properties"));
		
		System.setProperty(prop.getProperty("driver.chrome"), prop.getProperty("chrome.path"));
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://google.com/");
		Wait.untilJqueryIsDone(driver);
		Wait.untilPageLoadComplete(driver);
		Wait.waitForJSandJQueryToLoad(driver);
		System.out.println("Page ttile " + driver.getTitle());
		Reporter.log("Page ttile " + driver.getTitle());
		driver.findElement(By.name("q")).sendKeys("hello");
		Thread.sleep(5000);
		Actions action = new Actions(driver);
		String a = action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).toString();
		System.out.println(a);
		action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
		driver.quit();
	}
}
