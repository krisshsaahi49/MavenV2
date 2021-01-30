package com.java8.Streams;

import java.util.ArrayList;
import java.util.List;

public class JavaStreamReduce {
	public static void main(String[] args) {
		List<Product> productsList = new ArrayList<Product>();
		// Adding Products
		productsList.add(new Product(1, "HP Laptop", 25000f));
		productsList.add(new Product(2, "Dell Laptop", 30000f));
		productsList.add(new Product(3, "Lenevo Laptop", 28000f));
		productsList.add(new Product(4, "Sony Laptop", 28000f));
		productsList.add(new Product(5, "Apple Laptop", 90000f));
		// This is more compact approach for filtering data
		Float totalPrice = productsList.stream().map(product -> product.price).reduce(0.0f,
				(sum, price) -> sum + price); // accumulating price
		System.out.println(totalPrice);
		// More precise code
		float totalPrice2 = productsList.stream().map(product -> product.price).reduce(0.0f, Float::sum); 
		// accumulating price, by referring method of Float class
		System.out.println(totalPrice2);
		
		// Max Price
		float price = productsList.stream().map(p->p.price).reduce(0f, Float::max);
		System.out.println("Max Price : "+price);
				

	}
}
