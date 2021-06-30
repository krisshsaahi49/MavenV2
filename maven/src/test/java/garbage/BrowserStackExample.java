package garbage;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class BrowserStackExample{

	  public static void main(String[] args) throws MalformedURLException, InterruptedException {
	    
	      DesiredCapabilities caps = new DesiredCapabilities();
	      
	      // Set your access credentials
	      caps.setCapability("browserstack.user", "krishnasaahiyava1");
	      caps.setCapability("browserstack.key", "opf5K5xYctExedpsAFPz");
	      
	      
	      // Specify device and os_version for testing
	      caps.setCapability("device", "Google Pixel 3");
	      caps.setCapability("os_version", "9.0");
	        
	      // Set other BrowserStack capabilities
	      caps.setCapability("project", "First Java Project");
	      caps.setCapability("build", "Java Android");
	      caps.setCapability("name", "first_test");
	        
	      
	      // Initialise the remote Webdriver using BrowserStack remote URL
	      // and desired capabilities defined above
	        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(
	            new URL("http://hub.browserstack.com/wd/hub"), caps);
	        

	      /* Write your Custom code here */
	      driver.get("https://google.com");
	      System.out.println(driver.getTitle());
	      driver.findElement(By.name("q")).sendKeys("Oracle",Keys.ENTER);
	      System.out.println(driver.getTitle());
	        
	      // Invoke driver.quit() after the test is done to indicate that the test is completed.
	      driver.quit();
	    
	    }
	      
	  }
