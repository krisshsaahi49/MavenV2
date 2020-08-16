package executionTime;

import org.testng.annotations.Test;

public class NanoTime {
	
	@Test
	public void test1() {
		// TODO Auto-generated method stub
		long starttime = System.nanoTime();
		
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		long endtime = System.nanoTime();
		
		System.out.print("Execution time : "+(endtime-starttime));
		
		System.out.println(9*10E9);
	}

}
