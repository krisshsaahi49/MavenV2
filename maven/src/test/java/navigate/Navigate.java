package navigate;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Navigate {
	WebDriver driver;
	
	public boolean waitForJSandJQueryToLoad(WebDriver driver) {

	    WebDriverWait wait = new WebDriverWait(driver, 30);

	    // wait for jQuery to load 
	    
	    ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
	      @Override
	      public Boolean apply(WebDriver driver) {
	        try {
	        	
	        	System.out.println("page title : "+driver.getCurrentUrl());
	          return ((Long)((JavascriptExecutor)driver).executeScript("return jQuery.active") == 0);
	        }
	        catch (Exception e) {
	          // no jQuery present
	          return true;
	        }
	      }
	    };

	    // wait for Javascript to load
	    ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
	      @Override
	      public Boolean apply(WebDriver driver) {
	        return ((JavascriptExecutor)driver).executeScript("return document.readyState")
	        .toString().equals("complete");
	      }
	    };

	  return wait.until(jQueryLoad) && wait.until(jsLoad);
	}

	@Test
	public void chrome() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://google.com");
		waitForJSandJQueryToLoad(driver);
		System.out.println("Page ttile " + driver.getTitle());
		Reporter.log("Page ttile " + driver.getTitle());
	}

	/*
	 * @Test public void ie() { WebDriverManager.iedriver().setup(); driver = new
	 * InternetExplorerDriver(); driver.manage().window().maximize();
	 * driver.get("https://google.com");
	 * System.out.println("Page ttile "+driver.getTitle());
	 * Reporter.log("Page ttile "+driver.getTitle()); }
	 */

	@Test(enabled = false)
	public void firefox() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://google.com");
		System.out.println("Page ttile " + driver.getTitle());
		Reporter.log("Page ttile " + driver.getTitle());
	}

	@Test(enabled = false)
	public void edge() {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://google.com");
		System.out.println("Page ttile " + driver.getTitle());
		Reporter.log("Page ttile " + driver.getTitle());
	}

	@AfterClass
	public void teardown() {
		driver.quit();
	}
}
