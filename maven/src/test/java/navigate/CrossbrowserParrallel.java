package navigate;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CrossbrowserParrallel {
	WebDriver driver;
	
	@BeforeClass
	@Parameters("browser")
	public void setUpMethod(String browser) {
		// Loading properties file
		Properties prop = new Properties();
	    InputStream input = null;
		try {

	        input = new FileInputStream("application.properties");

	        // load a properties file
	        prop.load(input);

	        // get the property value and print it out
	        System.out.println(prop.getProperty("driver.chrome"));
	        System.out.println(prop.getProperty("driver.Chrome"));

	    } catch (IOException ex) {
	        ex.printStackTrace();
	    } finally {
	        if (input != null) {
	            try {
	                input.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	// *******************************************************	
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		}else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.manage().window().maximize();
		}
	}

	@Test
	public void test1() {
		driver.get("https://bing.com");
		System.out.println("Page ttile " + driver.getTitle());
		Reporter.log("Page ttile " + driver.getTitle());
	}
	
	@Test(enabled=false)
	public void test2() {
		driver.get("https://google.com");
		System.out.println("Page ttile " + driver.getTitle());
		Reporter.log("Page ttile " + driver.getTitle());
	}

	
	@AfterClass
	public void teardown() {
		driver.quit();
	}
}
