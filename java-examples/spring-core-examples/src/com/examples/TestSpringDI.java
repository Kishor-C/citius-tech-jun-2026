package com.examples;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpringDI {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		DBUtil util1 = (DBUtil) context.getBean("util");
		DBUtil util2 = (DBUtil) context.getBean("utilTest");
		util1.getConnection();
		util2.getConnection();
		
		// to close the resource
		ClassPathXmlApplicationContext context2 = (ClassPathXmlApplicationContext)context;
		context2.close();
	}
}
