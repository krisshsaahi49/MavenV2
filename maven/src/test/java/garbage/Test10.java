package garbage;

import java.time.Duration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.apache.commons.lang3.text.StrBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test10 {

	@Test
	public  void main() {
		int list[] = { 45, 78, 22, 96, 10, 87, 68, 2 };


		for(int i=list.length;i>0;i--) {

			for(int j=0;j<i-1;j++) {
				if(list[j]>list[j+1]) {
					list[j] = list[j] + list[j+1];
					list[j+1] = list[j] - list[j+1];
					list[j] = list[j] - list[j+1];
				}
			}
		}

		for(int a : list) {
			System.out.println(a);
		}
	}

	@Test
	public  void charArr() {
		String s = "gainsight";
		char[] list = s.toCharArray();	

		for(int i=list.length;i>0;i--) {

			for(int j=0;j<i-1;j++) {
				if(list[j]>list[j+1]) {
					char temp = list[j];
					list[j] = list[j+1];
					list[j+1] = temp;
				}
			}
		}

		for(char a : list) {
			System.out.println(a);
		}
		
		Map<Character,Integer> map = new HashMap<Character, Integer>();
		for(int i =0;i<list.length;i++) {
			int count=1;
			if(map.containsKey(list[i])) {
				map.put(list[i], count+1);
			}else {
				map.put(list[i], count);
			}
		}
		
		map.forEach((k,v)->System.out.println(k+" "+v));
	}
	
	@Test
	public void split() {
		String s = "1 EURO (EUR) = 1.2641 U.S. dollar (USD)";
		String[] a = s.split("=", 6);
		String value = a[1].trim().substring(0,7).trim();
		System.out.println(value);
		
		Double i = Double.parseDouble(value);
		
		Double con = 126/i;
		   double roundDbl = Math.round(con*100.0)/100.0;
		System.out.println(i+" "+roundDbl);
		
		
	}
	
	@Test
	public void seleniumWait() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://oracle.com");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);  // Implicit wait
		
		WebDriverWait wait = new WebDriverWait(driver, 5);				// Explicit wait
		WebElement oracle = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[contains(text(),'Oracle Cloud ')]")));
		oracle.click();
		
		Wait<WebDriver> w = new FluentWait(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(2)).ignoring(Exception.class); // Fluent wait
		WebElement text = w.until(new Function<WebDriver, WebElement>() {

			@Override
			public WebElement apply(WebDriver t) {
				// TODO Auto-generated method stub
				return t.findElement(By.xpath("//h3[contains(text(),'Oracle Cloud Applications')]//following::a[1]"));
			}
			
		});
		
		text.click();
		driver.close();
	}
	
	@Test
	public void stringReverse() {
		String s = "Krishna saahi";
		// using stringbuider and reverse
		StringBuilder str = new StringBuilder(s);
		System.out.println(str.reverse());
		
		// without string reverse
		char[] arr = s.toCharArray();
		for(int i=arr.length;i>0;i--) {
			System.out.print(arr[i-1]);
		}
		System.out.println("\n");
	}
	
	@Test
	public void swapWithoutTemp() {
		int i=0,j=2;
		i = i+j;
		j = i-j;
		i = i-j;
		System.out.println(i+" "+j);
	}
	
	@Test
	public void swapStringWithoutTemp() {
		String s1="krissh",s2="saahi";
		s1 = s1+s2;
		s2 = s1.substring(0,s1.length()-s2.length());
		s1 = s1.substring(s2.length());
		
		System.out.println(s1+" "+s2);
		String s3 = "helloIamKrissh";
		System.out.println(s3.substring(5));
	}
	
	@Test
	public void iterateMap() {
		// using map entry
		Map<String, Integer> map = new HashMap();
		map.put("A", 1);map.put("D", 4);map.put("B", 3);map.put("E", 2);map.put("C", 5);
		
		for(Map.Entry<String, Integer> a : map.entrySet()) {
			System.out.println(a.getKey()+" "+a.getValue());
		}
		
		for(String a :map.keySet()) {
			System.out.println(a+" "+map.get(a));
		}
		
	 	Set<Entry<String, Integer>> a = map.entrySet();
	 	
	 	// find key using value
	 	for(Entry<String, Integer> a1 : a) {
	 		if(a1.getValue()==3) {
	 			System.out.println(a1.getKey());
	 		}
	 		
	 	}
	 	
	 	// find maxx value in a map
	 	Entry<String, Integer> maxEntry = null;
	 	for(Entry<String, Integer> a1 : a) {
	 		if(maxEntry==null || a1.getValue().compareTo(maxEntry.getValue())>0) {
	 			maxEntry = a1;
	 		}
	 	}
	 	
	 	System.out.println(maxEntry.getKey()+" "+maxEntry.getValue());
	}
	
	@Test
	public void rotateStringCheck() {
		String s1 = "stackoverflow";
		String s2 = "stackoverflwo";
		
		if((s1+s1).contains(s2)) {
			System.out.println("rotation");
		}else {
			System.out.println("Nope duh!");
		}
	}
	
}


