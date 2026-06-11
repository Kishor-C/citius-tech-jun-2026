package com.examples;

public class Product {
	private int id;
	private String name;
	private double price;
	//Product(){}
	public Product() {
		System.out.println("default constructor");
	}
	public Product(int id, String name, double price) {
		this.id = id;
		this.name = name;
		this.price = price;
		System.out.println("3 parameterized constructor");
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public String getName() {
		return name;
	}
	public int getId() {
		return id;
	}
	public void printDetails() {
		System.out.println("id="+id+",name="+name+",price="+price);
	}
}
