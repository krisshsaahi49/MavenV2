package test;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageObject extends BaseTest{

	@FindBy(name = "q")
	WebElement search;

	public void search() {
		DriverFactory.getInstance().getDriver().get("https://google.com");
		search.sendKeys("Oracle",Keys.ENTER);
		System.out.println(DriverFactory.getInstance().getDriver().getTitle());
	}

	
	  public PageObject() {
	  PageFactory.initElements(DriverFactory.getInstance().getDriver(), this); }
	 }
