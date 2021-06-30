import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

public class Test1 {

	@Test
	public void removeDuplicates() {
		String s = "hyderabad";
		
		String[] arr = s.split("");
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		for(String a : arr) {
			map.put(a, null);
		}
		
		map.forEach((k,v) -> System.out.println(k));
	}
	
	//  “IndiaVsEnglandIndiaVsEngland", "EnglandIndiaVs”
	@Test
	public void rotation() {
		String s1 = "IndiaVsEngland";
		String s2 = "EnglandIndiaVs";
		
		if((s1+s1).contains(s2)) {
			System.out.println("String rotation is available");
		}else {
			System.out.println("String rotation is  not available");
		}
	}
}
