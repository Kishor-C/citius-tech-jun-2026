package com.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory factory;
	private static Session session;
	
	public static Session getSession() {
		Configuration configuration = new Configuration();
		configuration.configure(); // creates connection factory
		// access Session Factory
		factory = configuration.buildSessionFactory();
		// create session 
		session = factory.openSession();
		return session;
	}
	public static void close() {
		session.close();
		factory.close();
	}
}
