package selenium22tips;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import lib.FileUtility;

public class All22Tips extends FileUtility {
	private WebDriver driver;

	@Test // Not working
	public void webdrivertAtExecutables() {
//		WebDriverManager.iedriver().setup();
		driver = new FirefoxDriver();
		driver.navigate().to("https://jquery.com/");

	}

	@Test // Capture screenshot
	public void captureScreenshot() throws IOException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://jquery.com/");
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile,
				new File(System.getProperty("user.dir") + "//Screenshots//" + getTimeStamp() + "_screenshot.png"));
		driver.quit();
	}

	@Test // Switch to tab and close
	public void openTab() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://jquery.com/");
		// Open new tab
		((JavascriptExecutor) driver).executeScript("window1 = window.open('https://www.youtube.com', '_self')");
		Thread.sleep(5000);
		// close tab
		((JavascriptExecutor) driver).executeScript("window1.close()");
		Thread.sleep(5000);
		((JavascriptExecutor) driver).executeScript("window2 = window.open('https://www.bing.com', '_blank')");
		Thread.sleep(5000);
		((JavascriptExecutor) driver).executeScript("window2.close()");
		driver.quit();
	}

	@Test // Zoom In and ouut
	public void zoomInandOut() throws InterruptedException {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://jquery.com/");
		// Zoom 200%
		((JavascriptExecutor) driver).executeScript("document.body.style.MozTransform = 'scale(2.0)';");
		((JavascriptExecutor) driver).executeScript("document.body.style.MozTransformOrigin  = '0 0';");
		Thread.sleep(5000);
		// Zoom 100%
		((JavascriptExecutor) driver).executeScript("document.body.style.MozTransform = 'scale(1.0)';");
		((JavascriptExecutor) driver).executeScript("document.body.style.MozTransformOrigin  = '0 0';");
		Thread.sleep(5000);
		driver.quit();
	}

	@Test // js functions
	public void jsFunc() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://jquery.com/");
		String url = ((JavascriptExecutor) driver).executeScript("return document.title;").toString();
		Reporter.log(url);

		String browser = ((JavascriptExecutor) driver).executeScript("return navigator.product").toString();
		Reporter.log(((JavascriptExecutor) driver).executeScript("return navigator.product").toString() + " || "
				+ ((JavascriptExecutor) driver).executeScript("return navigator.appVersion").toString());
		Reporter.log(((JavascriptExecutor) driver).executeScript("return navigator.appCodeName").toString() + " || "
				+ ((JavascriptExecutor) driver).executeScript("return navigator.userAgent").toString());
		Reporter.log(((JavascriptExecutor) driver).executeScript("return navigator.platform").toString() + " || "
				+ ((JavascriptExecutor) driver).executeScript("return navigator.language").toString());

		Reporter.log(((JavascriptExecutor) driver).executeScript("return navigator.onLine").toString() + " || "
				+ ((JavascriptExecutor) driver).executeScript("return navigator.javaEnabled()").toString());
		Reporter.log(((JavascriptExecutor) driver).executeScript("return document.links.length;").toString());
//		((JavascriptExecutor) driver).executeScript("document.body.style.background='#008000';");
		Reporter.log(((JavascriptExecutor) driver).executeScript("return document.body.style.background;").toString());
		driver.quit();
	}
	
	@Test
	public void open() throws MalformedURLException {
		
		  WebDriverManager.chromedriver().setup(); driver = new ChromeDriver();
		  driver.manage().window().maximize();
//		  driver.navigate().to("http://google.com");
		 
		System.out.println(new File("C:\\index.html").toURI().toURL());
		driver.navigate().to(new File("C:\\index.html").toURI().toURL());
	}
	
	@Test
	public void sample() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://jquery.com/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// close tab
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement jquery = driver.findElement(By.xpath("//img[@alt='Support the JS Foundation']"));
		wait.until(ExpectedConditions.presenceOfElementLocated((By) jquery));
		jquery.click();
		
	}
	
	@Test
	public void a() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("start-maximized");
		WebDriver driver = new ChromeDriver(opt);
		driver.get("https://bing.com");
//		((JavascriptExecutor) driver).executeScript("window1 = window.open('https://bing.com');");
//		((JavascriptExecutor) driver).executeScript("window1.close()");
		((JavascriptExecutor) driver).executeScript("document.getElementById('sb_form_q').value='Abha_Rathour'");  // send keys using js
		WebElement search = driver.findElement(By.id("sb_form_q"));
		WebElement maginifier = driver.findElement(By.xpath("//label[@class='search icon tooltip']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",maginifier);
		((JavascriptExecutor) driver).executeScript("history.go(0)");
		WebElement help = driver.findElement(By.id("sb_help"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",help);
		Thread.sleep(2000);
		
		driver.close();
	}
}
