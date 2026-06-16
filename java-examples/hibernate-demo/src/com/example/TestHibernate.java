package com.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestHibernate {
	public static void main(String[] args) {
		// create a package main.resources and place the hibernate.cfg.xml
		Configuration configuration = new Configuration();
		configuration.configure(); // creates connection factory
		// access Session Factory
		SessionFactory factory = configuration.buildSessionFactory();
		// create session 
		Session session = factory.openSession();
		// create Transaction if you are making changes
		Transaction transaction = session.beginTransaction();
		Employee employee1 = new Employee("Ajay", 50000);
		Employee employee2 = new Employee("Vijay", 60000);
		Employee employee3 = new Employee("Suraj", 40000);
		session.persist(employee1);
		session.persist(employee2);
		session.persist(employee3);
		transaction.commit();
		session.close();
		factory.close();
		System.out.println("DONE");
	}
}
