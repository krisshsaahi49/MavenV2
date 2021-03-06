package com.Tesng.Annotations;

import org.testng.annotations.Test;

public class TestngWithXML {
	
	@Test(groups = {"regression,","smoke"})
	public void test() {
		System.out.println(" Test ");
	}
	
	@Test(groups = {"regression,","smoke","uat"})
	public void abc() {
		System.out.println(" Test abc ");
	}
	
	@Test(groups = {"regression,","smoke"})
	public void abcd() {
		System.out.println(" Test abcd ");
	}
	
	@Test(groups = {"regression"})
	public void test2() {
		System.out.println(" Test 2 ");
	}
	
	@Test(groups = {"uat"})
	public void test3() {
		System.out.println(" Test 3 ");
	}
	
	@Test(groups = {"smoke"})
	public void abcd1() {
		System.out.println(" Test abcd1 ");
	}
	
	@Test(groups = {"smoke"})
	public void abcde() {
		System.out.println(" Test abcde ");
	}
	
	@Test(groups = {"regression"})
	public void testt() {
		System.out.println(" Testt ");
	}
}
