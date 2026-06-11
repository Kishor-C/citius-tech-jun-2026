package com.examples;

import java.time.LocalDate;

public class TestInheritance {
	public static void main(String[] args) {
		User user1 = new User("Raj", 9292392933L);
		System.out.println("________________________________________");
		Employee employee1 = new Employee(1, "Vijay", 8899887755L, 45000.0);
		System.out.println("________________________________________");
		//ISO - yyyy-MM-dd
		Customer customer1 = new Customer(8877, "Sachin", 7766554433L, LocalDate.parse("2023-11-25")); 
		System.out.println("________________________________________");
		System.out.println("Name = "+user1.getName()+", Phone = "+user1.getPhone());	
		System.out.println("________________________________________");
		System.out.println("Name = "+employee1.getName()+", Salary = "+employee1.getSalary());	
		System.out.println("________________________________________");
		System.out.println("Name = "+customer1.getName()+", Joining Date = "+customer1.getJoiningDate());	
	}
}
