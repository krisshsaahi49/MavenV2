package com.apache.ApachePoi;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExcelRead2 {
	public static WebDriver driver;
	public static FileInputStream input;
	public static FileOutputStream output;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static int rowCount;
	public static String BROWSER="CHROME";  
	
	static {
		try {
			input = new FileInputStream("data/url.xlsx");
			workbook = new XSSFWorkbook(input);
			sheet = workbook.getSheetAt(0);
			rowCount = sheet.getPhysicalNumberOfRows();
			// clearing up status
			for (int i = 1; i < rowCount; i++) {
				sheet.getRow(i).createCell(1).setCellValue("");
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Parameters("browser")
	ExcelRead2(String browser){

		BROWSER="FF"; // GC,FF,EDGE,IE
		BROWSER=browser;

		if (BROWSER.equals("GC")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("start-maximized");
			options.setHeadless(false);
			driver = new ChromeDriver(options);
		}else if(BROWSER.equals("FF")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}else if(BROWSER.equals("IE")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}else if(BROWSER.equals("MOBILE")) {
			WebDriverManager.chromedriver().setup();
			Map<String, Object> deviceMetrics = new HashMap<String, Object>();
			deviceMetrics.put("width", 414);
			deviceMetrics.put("height", 736);
			deviceMetrics.put("pixelRatio", 4.0);
			Map<String, Object> mobileEmulation = new HashMap<String, Object>();
			mobileEmulation.put("deviceMetrics", deviceMetrics);
			mobileEmulation.put("userAgent",
					"Mozilla/5.0 (iPhone; CPU iPhone OS 12_0 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) FxiOS/13.2b11866 Mobile/16A366 Safari/605.1.15");
			Map<String, Object> chromeOptions = new HashMap<String, Object>();
			chromeOptions.put("mobileEmulation", mobileEmulation);
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
			driver = new ChromeDriver(capabilities);
		}

	
	}
	
	@Test
	public void launchUrl() {
		System.out.println("Number of rows : " + rowCount);
		driver.get("https://fb.com");
		for (int i = 1; i < rowCount; i++) {
			System.out.println("Launching URL : " + sheet.getRow(i).getCell(0).getStringCellValue());
			driver.navigate().to(sheet.getRow(i).getCell(0).getStringCellValue().toString());
			sheet.getRow(i).createCell(1).setCellValue(driver.getTitle());
		}

	}
	
	@AfterTest
	public void endTest() {
		try {
//			input.close();
			output = new FileOutputStream("data/url_"+BROWSER+".xlsx");
			workbook.write(output);
			output.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.quit();
	}
	
	@AfterSuite
	public void endAll() {
		try {
			input.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
