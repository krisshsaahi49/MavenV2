package com.java.encapsulation;

public class IamHidden {

	private String pName;
	private String pDOB;
	private String pAge;
	
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		System.out.println("U caught my name!");
		this.pName = pName;
	}
	public String getpDOB() {
		return pDOB;
	}
	public void setpDOB(String pDOB) {
		this.pDOB = pDOB;
	}
	public String getpAge() {
		return pAge;
	}
	public void setpAge(String pAge) {
		this.pAge = pAge;
	}	
	
}
