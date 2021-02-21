package com.java.Performance;

public class Employee {
	String Name;
	int Id;
	String Company;
	
	public Employee(String Name,int Id,String Company) {
		this.Name = Name;
		this.Id = Id;
		this.Company = Company;
	}
	
	public void display() {
		System.out.println(Company+"    "+Name+"   "+Id);
	}
}
