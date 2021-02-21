package testAutomation.POM.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class LoginPageFactory {

//	WebDriver driver;
	public WebDriver d;
	
	@FindBy(name = "uid")
	WebElement user99GuruName;

	@FindBy(name = "password")
	WebElement password99Guru;

	@FindBy(className = "barone")
	WebElement titleText;

	@FindBy(name = "btnLogin")
	WebElement login;
	
	public LoginPageFactory(WebDriver driver) {
//		this.driver = driver;
		AjaxElementLocatorFactory ajax = new AjaxElementLocatorFactory(driver, 100);
		PageFactory.initElements(driver, this);
		PageFactory.initElements(ajax, this);
	}

	public void Login() {
		user99GuruName.sendKeys("mgr123");
		password99Guru.sendKeys("mgr!23");
		login.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
