package com.examples;

public class Main {

	public static void main(String[] args) {
		int[] items = {25, 10, 35, 20, 15};
		sum(items);
		// enhanced for loop
		for(int ele : items) { // ele = 15
			System.out.println("Item = "+ele);
		}
		System.out.println("main ends here");
	}
	public static void sum(int[] arr) {
		int total = 0;
		for(int ele : arr) {
			total = total + ele;
		}
		System.out.println("Total="+total);
	}
}
