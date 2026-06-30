package com.examples;

public class Greetings {
	public Greetings() {
		System.out.println("Greetings() constructor");
	}
	public String greet(String name) {
		return "Hello "+name;
	}
	public void initializer() {
		System.out.println("Initialize some resource");
	}
	public void cleanup() {
		System.out.println("Cleanup some resouce");
	}
}
