package com.examples;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpringContext {
	public static void main(String[] args) {
		/*
		 * ApplicationContext is the reference to the spring container
		 * IOC, ApplicationContext is an interface that has methods 
		 * to get the object, it is implemented by a class called
		 * 'ClassPathXmlApplicationContext'
		 */
		// initializing the spring container
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		// to access the object
		DBUtil dbUtil1 = context.getBean(DBUtil.class);
		DBUtil dbUtil2 = (DBUtil)context.getBean("util");
		System.out.println(dbUtil1);
		System.out.println(dbUtil2);
		
		/*
		 * Create another class Greetings with a greet(String name) method that returns Hello <<name>>
		 * Configure this class in the XML and from main method get this object and call the greet() passing your name
		 * Print the message you get from the greet
		 * 
		 */
		Greetings greetings = context.getBean(Greetings.class);
		System.out.println(greetings.greet("Kishor"));
		
	}
}
