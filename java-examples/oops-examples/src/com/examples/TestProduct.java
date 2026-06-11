package com.examples;

public class TestProduct {
	public static void main(String[] args) {
		// create product object
		Product product1 = new Product(500, "Bag", 2500.0); 
		//modify the price
		product1.setPrice(2300.0);
		// read the id
		int id = product1.getId();
		// print only the id - in web / mobile app
		System.out.println("id = "+id);
		Product product2  = new Product(600,"Shoes", 3000.0); 
		
		product1.printDetails();
		product2.printDetails();
	}
}
/*
 *  Customer - id, name, phone, gender, age
 *  Admin - employeeId, name, phone, gender, age, salary, accessKey
 *  CustomerExecutive - employeeId, name, phone, gender, age, salary, pendingTickets = 150
 */
