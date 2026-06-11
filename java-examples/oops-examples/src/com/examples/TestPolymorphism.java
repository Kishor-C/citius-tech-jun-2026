package com.examples;

import java.time.LocalDate;

public class TestPolymorphism {
	public static void main(String[] args) {
		User user1 = new User("Raj", 9292392933L);
		System.out.println("________________________________________");
		Employee employee1 = new Employee(1, "Vijay", 8899887755L, 45000.0);
		System.out.println("________________________________________");
		//ISO - yyyy-MM-dd
		Customer customer1 = new Customer(8877, "Sachin", 7766554433L, LocalDate.parse("2023-11-25")); 
		System.out.println("________________________________________");
		// we can pass all the objects of User & its subclass to the printDetails
		printDetails(user1);
		printDetails(employee1);
		printDetails(customer1);
	}
	public static void printDetails(User user) {
		user.display();
		System.out.println("___________________________________________");
	}
}
/*
 * int x = 20;
 * long y = x;
 * 
 */
