package com.java.encapsulation;

import org.testng.annotations.Test;

public class Encapsulation {

	@Test
	public void getDetails() {
		IamHidden obj = new IamHidden();
		obj.setpName("Krissh");
		obj.setpDOB("21 Dec 1994");
		obj.setpAge("26");
		
		System.out.println(obj.getpName()+"  "+obj.getpDOB()+"  "+obj.getpAge());
	}


	@Test
	public void getImp() {
		Abs1 a = new Implementation();
		Interf i = new Implementation();
		a.a();a.b();
		i.a();i.c();
	}
	
	@Test
	public void anonym() {
		Interf i = new Interf() {
			
			@Override
			public void c() {
				// TODO Auto-generated method stub
				System.out.println("Anonymous class method c");
			}
			
			@Override
			public void a() {
				// TODO Auto-generated method stub
				System.out.println("Anonymous class method a");
			}
		};
		
		i.a();i.c();
	}
	
	@Test
	public void funcInterf() {
		FuncInterf obj = () -> {System.out.println("Hello");};
		obj.abc();
		
		
	}
}

