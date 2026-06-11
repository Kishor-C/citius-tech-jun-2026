package com.examples;

import java.util.ArrayList;
import java.util.List;

public class TestList {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("hello");
		list.add("welcome");
		list.add("hi");
		System.out.println(list);
		list.add(0, "thankyou");
		System.out.println(list);
		list.set(0, "thanks");
		System.out.println(list);
		System.out.println(list.get(2));
	}
}
