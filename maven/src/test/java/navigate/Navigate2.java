package navigate;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import lib.Wait;

public class Navigate2 {
	WebDriver driver;
	
	@org.testng.annotations.Test
	public void chrome() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jquery.com/");
		Wait.untilJqueryIsDone(driver);
		Wait.untilPageLoadComplete(driver);
		Wait.waitForJSandJQueryToLoad(driver);
		System.out.println("Page ttile " + driver.getTitle());
		Reporter.log("Page ttile " + driver.getTitle());
		driver.quit();
	}
}
