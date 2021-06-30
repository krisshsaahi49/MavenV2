package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageObject2 extends BaseTest{

	
	By search = By.name("q");

	public void search() {
		DriverFactory.getInstance().getDriver().get("https://google.com");
		DriverFactory.getInstance().getDriver().findElement(search).sendKeys("Oracle",Keys.ENTER);
	}
}
