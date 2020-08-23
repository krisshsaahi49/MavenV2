package com.GetterSetter;

public class Client1 {

	public static void main(String[] args) {
		SimpleGetterAndSetter obj = new SimpleGetterAndSetter();
		obj.num = 10;;
		obj.setNumber(100);
		obj.b(20);
		System.out.println(obj.getNumber()+" "+obj.num+" "+obj.a());

	}

}
