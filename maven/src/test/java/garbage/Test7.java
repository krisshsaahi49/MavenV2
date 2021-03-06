package garbage;

import org.testng.annotations.Test;

public class Test7{
	
	@Test
	public void set() {
		String[] s = new String[10];
		for(int i=0;i<10;i++) {
			s[i] = "a";
		}
	}
}
