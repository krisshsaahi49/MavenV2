package parallelExecution;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import lib.Wait;

public class CrossBrowserParallel {

	public WebDriver driver;

	@Parameters("browser")
	CrossBrowserParallel(String browser) {

		if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		} else if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		} else if (browser.equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
		} else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.manage().window().maximize();
		}
	}

	@BeforeClass

	// Passing Browser parameter from TestNG xml

	/*
	 * public void beforeTest(String browser) {
	 * 
	 * // If the browser is Firefox, then do this
	 * 
	 * if (browser.equalsIgnoreCase("firefox")) {
	 * 
	 * //Initializing the firefox driver (Gecko)
	 * WebDriverManager.firefoxdriver().setup(); driver = new FirefoxDriver();
	 * 
	 * } else if (browser.equalsIgnoreCase("chrome")) {
	 * 
	 * // Initialize the chrome driver WebDriverManager.chromedriver().setup();
	 * driver = new ChromeDriver();
	 * 
	 * }
	 * 
	 * driver.get("https://www.demoqa.com");
	 * 
	 * }
	 */

	// Once Before method is completed, Test method will start

	@Test
	public void login() throws InterruptedException {
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
	}

	@AfterClass
	public void afterTest() {
		driver.quit();
	}

}
