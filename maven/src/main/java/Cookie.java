import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;		

public class Cookie{	
    

    public static void main(String[] args)		
    {
    	WebDriver driver;	
    	WebDriverManager.chromedriver().setup();
//        System.setProperty("webdriver.chrome.driver","G:///chromedriver.exe");					
		driver=new ChromeDriver();      
		driver.manage().window().maximize();
		driver.get("https://www.wellsfargo.com/spanish");				
        		
        // create file named Cookies to store Login Information		
        File file = new File("C:\\Users\\kriss\\OneDrive\\Desktop\\Cookies\\Cookies.data");							
        try		
        {	  
            // Delete old file if exists
			file.delete();		
            file.createNewFile();			
            FileWriter fileWrite = new FileWriter(file);							
            BufferedWriter Bwrite = new BufferedWriter(fileWrite);							
            // loop for getting the cookie information 		
            	
            // loop for getting the cookie information 		
			/*
			 * for(org.openqa.selenium.Cookie ck : driver.manage().getCookies()) {
			 * Bwrite.write((ck.getName()+";"+ck.getValue()+";"+ck.getDomain()+";"+ck.
			 * getPath()+";"+ck.getExpiry()+";"+ck.isSecure())); Bwrite.newLine(); }
			 */	
            
            org.openqa.selenium.Cookie ck = driver.manage().getCookieNamed("INLANG");
            Bwrite.write((ck.getName()+";"+ck.getValue()+";"+ck.getDomain()+";"+ck.getPath()+";"+ck.getExpiry()+";"+ck.isSecure())); Bwrite.newLine();
            Bwrite.close();			
            fileWrite.close();	
            
        }
        catch(Exception ex)					
        {		
            ex.printStackTrace();			
        }		
        driver.quit();
    }		
}
