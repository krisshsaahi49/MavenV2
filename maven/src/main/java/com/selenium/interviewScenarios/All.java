package com.selenium.interviewScenarios;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class All {
	WebDriver driver ;

	@Test
	public void handlingSSLCert() throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		options.addArguments("disable-infobars"); // deprecated in latest version
		options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});  // experimental workaround for disable info bars
		options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
//		options.setAcceptInsecureCerts(true);   // can use this one too
		WebDriverManager.chromedriver().setup();
		driver =  new ChromeDriver(options);
		driver.get("https://www.cacert.org/");
		Thread.sleep(5000);
		driver.quit();
	}
	
	@Test
	public void resizeWindow() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("window-size=480,620");  // method 1 :  resizing from chromeoptions
		driver = new ChromeDriver(options);
		driver.get("https://bing.com");
		
		Dimension d = new Dimension(1200, 1200);  // Method 2  :using dimension and window.setSize()
		driver.manage().window().setSize(d);
		driver.quit();
	}
	
	@Test
	public void seleniumWaits() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://spejntuk.org/");
		waitforPageLoad(driver);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // implicit wait - wait for specific time even all elemets are loaded and it is applicable to all webelments mentionted in the test case
		WebDriverWait wait = new WebDriverWait(driver, 10); // explicit wait - wait for expected conidtion or specific amount of time which ever comes first
		WebElement referene = driver.findElement(By.xpath("//span[contains(text(),'Brent Crude Oil')]"));
		wait.until(ExpectedConditions.visibilityOf(referene));
		WebElement fatNavEvents = driver.findElement(By.xpath("//div[@id='mainmenu']//a[contains(text(),'Events')]"));
		wait.until(ExpectedConditions.visibilityOf(fatNavEvents)).click();
		
		Wait<WebDriver> waitr = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(1)).ignoring(Exception.class);  // Fluent wait
		waitr.until(ExpectedConditions.titleContains("Events"));
		
		driver.quit();
	}
	
	public static boolean waitforPageLoad(WebDriver driver) {
		ExpectedCondition<Boolean> pageCondition = new ExpectedCondition<Boolean>() {

			@Override
			public Boolean apply(WebDriver driver) {
				// TODO Auto-generated method stub
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			}
		};
		
		WebDriverWait waitComplete = new WebDriverWait(driver, 10);
		return waitComplete.until(pageCondition);
	}
	
	@Test
	public void switchtoIframe() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.automationtestinginsider.com/2019/08/textarea-textarea-element-defines-multi.html");
		Thread.sleep(2000);
		//First finding the elements using any of locator strategy
		List<WebElement> iframList = driver.findElements(By.tagName("iframe"));
		int totalFrames = iframList.size();
		System.out.println("No of Frames:" + totalFrames);
		WebElement ele=driver.findElement(By.name("iframe_b"));
		System.out.println("Frame Names are:");
		for (WebElement iframe : iframList) {
			System.out.println(iframe.getAttribute("name"));
			if (iframe.getAttribute("name").equals("iframe_b")) {
				//switch to frame by element
				driver.switchTo().frame(ele);
				//Perform all the required tasks 
				driver.findElement(By.id("searchInput")).sendKeys("iframe Testing");
				Thread.sleep(2000);
				//Switching back to the main window
				driver.switchTo().defaultContent();
			}
		}
		boolean btnDisplayed=driver.findElement(By.id("simpleAlert")).isDisplayed();
		System.out.println(btnDisplayed);
		driver.close();
	}
	
	@Test
	public void charts() {
		WebDriverManager.chromedriver().setup();

		driver= new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("http://yuilibrary.com/yui/docs/charts/charts-pie.html");

		//Locate pie chart elements based on different colors.

		WebElement VioleteColor = driver.findElement(By.xpath("//*[contains(@class,'yui3-svgSvgPieSlice')][@fill='#66007f']"));

		WebElement GreenColor = driver.findElement(By.xpath("//*[contains(@class,'yui3-svgSvgPieSlice')][@fill='#295454']"));

		WebElement GreyColor = driver.findElement(By.xpath("//*[contains(@class,'yui3-svgSvgPieSlice')][@fill='#e8cdb7']"));

		WebElement LightVioleteColor = driver.findElement(By.xpath("//*[contains(@class,'yui3-svgSvgPieSlice')][@fill='#996ab2']"));

		WebElement BrownColor = driver.findElement(By.xpath("//*[contains(@class,'yui3-svgSvgPieSlice')][@fill='#a86f41']"));

		//locate tooltip pie chart.

		WebElement ToolTip = driver.findElement(By.xpath("//div[contains(@id,'_tooltip')]"));

		//Click on pie chart parts and get tooltip values.

		System.out.println("-X-X-X-X-X-X-X-X- Violete Part -X-X-X-X-X-X-X-X-");

		VioleteColor.click(); 

		System.out.println(ToolTip.getText());

		System.out.println(); 

		System.out.println("-X-X-X-X-X-X-X-X- Grey Part -X-X-X-X-X-X-X-X-");

		GreyColor.click();

		System.out.println(ToolTip.getText());

		System.out.println();

		System.out.println("-X-X-X-X-X-X-X-X- Light Violete Part -X-X-X-X-X-X-X-X-");

		LightVioleteColor.click();

		System.out.println(ToolTip.getText());

		System.out.println();

		System.out.println("-X-X-X-X-X-X-X-X- Green Part -X-X-X-X-X-X-X-X-");

		GreenColor.click();

		System.out.println(ToolTip.getText());

		System.out.println();

		System.out.println("-X-X-X-X-X-X-X-X- Brown Part -X-X-X-X-X-X-X-X-");

		BrownColor.click();

		System.out.println(ToolTip.getText());               
	}
	
	@Test
	public void tooltip2() {
		String jQueryURL = "https://jqueryui.com/tooltip/";

		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to(jQueryURL);

		// As there is frame, we have to navigate to frame

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector(
				".demo-frame")));

		
		// Text box field, where we mouse hover
		WebElement element = driver.findElement(By.id("age"));

		// Use action class to mouse hover on Text box field
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
//		WebElement toolTipElement = driver.findElement(By.cssSelector(".ui-tooltip"));
		WebElement toolTipElement = driver.findElement(By.xpath("//div[contains(@id,'ui-id')]"));

		// To get the tool tip text and assert
		String toolTipText = toolTipElement.getText();
		System.out.println(toolTipText);
		Assert.assertEquals("We ask for your age only for statistical purposes.", toolTipText);
		driver.close();
	}
	
	@Test
	public void links() throws MalformedURLException, IOException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized","headless");
		driver = new ChromeDriver(options);
		driver.get("https://youtube.com");
		List<WebElement> urls = driver.findElements(By.tagName("a"));
		HttpURLConnection huc=null;
		for(WebElement url : urls) {
//			System.out.println(url.getAttribute("href"));
			if(url.getAttribute("href")==null || url.getAttribute("href").isEmpty()) {
//				System.out.println("---No url----");
			}else {
				huc = (HttpURLConnection) (new
						URL(url.getAttribute("href"))).openConnection();
				huc.setRequestMethod("HEAD"); huc.connect();
				System.out.println(huc.getResponseCode()+ " | "+huc.getResponseMessage());
//				System.out.println(url.getAttribute("href"));
			}
			
		}
		driver.close();
	}
}
