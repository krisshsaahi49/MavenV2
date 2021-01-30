
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReadCookie {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		options.addArguments("--allow-insecure-localhost");
		driver = new ChromeDriver(options);
		driver.manage().deleteAllCookies();
		driver.get("https://www.wellsfargo.com");
		try {

			File file = new File("C:\\Users\\kriss\\OneDrive\\Desktop\\Cookies\\Cookies.data");
			FileReader fileReader = new FileReader(file);
			BufferedReader Buffreader = new BufferedReader(fileReader);
			String strline;
			while ((strline = Buffreader.readLine()) != null) {
				StringTokenizer token = new StringTokenizer(strline, ";");
				while (token.hasMoreTokens()) {
					String name = token.nextToken();
					System.out.println("Name : "+name);
					String value = token.nextToken();
					System.out.println("Value : "+value);
					String domain = token.nextToken();
					System.out.println("Domain : "+domain);
					String path = token.nextToken();
					System.out.println("Path : "+path);
					String  expiry1 = token.nextToken();
					Date expiry=new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy").parse(expiry1); 

					/*
					 * String val; if (!(val = token.nextToken()).equals("null")) { expiry = new
					 * Date(val); }
					 */
					Boolean isSecure = new Boolean(token.nextToken()).booleanValue();
					System.out.println("Secure : "+isSecure);
					
					  Cookie ck = new Cookie("INLANG", "ES");
					  System.out.println(ck); 
					  driver.manage().addCookie(ck);
					  // This will add the stored cookie to your current session
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
//		driver.get("https://www.wellsfargo.com");
		driver.navigate().refresh();
		Thread.sleep(10000);
	}
}
