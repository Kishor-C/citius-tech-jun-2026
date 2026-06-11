package com.examples;

public class User {
	private String name;
	private long phone;
	public User() {
		super();
		System.out.println("User() constructor");
	}
	public User(String name, long phone) {
		super();
		System.out.println("User(String, long) constructor");
		this.name = name;
		this.phone = phone;
	}
	public void display() {
		System.out.println("***** Displaying User details ******");	
		System.out.println("Name = "+name+", Phone = "+phone);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	
}
