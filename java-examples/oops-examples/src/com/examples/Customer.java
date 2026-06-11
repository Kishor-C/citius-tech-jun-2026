package com.examples;

import java.time.LocalDate;

public class Customer extends User {
	private int customerId;
	private LocalDate joiningDate;
	public Customer() {
		super();
		System.out.println("Customer() constructor");
	}
	public Customer(int customerId, String name, long phone, LocalDate joiningDate) {
		super(name, phone);
		System.out.println("Customer(int, String, long, LocalDate) customer");
		this.customerId = customerId;
		this.joiningDate = joiningDate;
	}
	@Override
	public void display() {
		System.out.println("***** Displaying Customer details ******");	
		System.out.println("Id = "+customerId+", Name = "+getName()+", Joining Date = "+joiningDate+", Phone = "+getPhone());
		// since name & phone belongs to User and they are private we must use getters
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public LocalDate getJoiningDate() {
		return joiningDate;
	}
	public void setJoiningDate(LocalDate joiningDate) {
		this.joiningDate = joiningDate;
	}
	
	
}
