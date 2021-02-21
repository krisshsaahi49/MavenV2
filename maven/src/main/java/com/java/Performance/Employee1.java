package com.java.Performance;

public class Employee1 {
	String Name;
	int Id;
	static String Company = "Apple";
	
	public Employee1(String Name,int Id) {
		this.Name = Name;
		this.Id = Id;
	}
	
	public void display() {
		System.out.println(Company+"    "+Name+"   "+Id);
	}
}
