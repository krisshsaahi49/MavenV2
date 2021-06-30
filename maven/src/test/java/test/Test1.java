package test;

import org.testng.annotations.Test;

public class Test1 extends BaseTest{

	@Test
	public void test1() {
		  PageObject obj = new PageObject(); 
		  obj.search();
	}
}
