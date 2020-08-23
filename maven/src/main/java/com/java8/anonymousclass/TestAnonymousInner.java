package com.java8.anonymousclass;

public class TestAnonymousInner {

	public static void main(String[] args) {
		// Method 2 - using anonymous class
		Person p = new Person() {
			@Override
			void eat() {
				System.out.println("Anonymous class implementation to abstract class");
			}
		};

		p.eat();

//		Method 1 - normal way of abstraction
		Person p1 = new Food();
		p1.eat();

//		Using Interface
		Drinks d = new Drinks() {

			@Override
			public void getDrinks() {

				System.out.println("I love pepsiiiii");
			}

			@Override
			public void getJuices() {
				
				System.out.println("I love appple juice...");
			}
		};
		
		d.getDrinks();
		d.getJuices();
	}

}
