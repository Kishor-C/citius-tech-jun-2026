package com.examples;

public class Employee extends User {
	// all the members of User is inherited except private members & constructors
	private int id;
	private double salary;
	public Employee() {
		super();
		System.out.println("Employee() constructor");
	}
	public Employee(int id, String name, long phone, double salary) {
		super(name, phone);
		System.out.println("Employee(int, String, long, double) constructor");
		this.id = id;
		this.salary = salary;

	}
	@Override
	public void display() {
		System.out.println("***** Displaying Employee details ******");	
		System.out.println("Id = "+id+", Name = "+getName()+", Salary = "+salary+", Phone = "+getPhone());
		// since name & phone belongs to User and they are private we must use getters
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	
	
}
