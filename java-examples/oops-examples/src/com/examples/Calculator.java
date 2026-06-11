package com.examples;

public class Calculator {
//	public int add(int x, int y) {
//		System.out.println("add(int, int)");
//		return (x + y);
//	}
//	public double add(double x, double y) {
//		System.out.println("add(double, double)");
//		return (x + y);
//	}
	public String add(int x, String y) {
		System.out.println("add(int, String)");
		return x + y;
	}
	public int add(int... x) {
		// x can accept 0 or more arguments and it is like an array
		System.out.println("add(int...)");
		int total = 0;
		for(int ele : x) {
			total = total + ele;
		}
		return total;
	}
	public static void main(String[] args) {
		// a static method must always create object to access non-static member
		Calculator calci = new Calculator();
		int result = (int)calci.add(10, 20);
		System.out.println("Result = "+result);
	}
}
