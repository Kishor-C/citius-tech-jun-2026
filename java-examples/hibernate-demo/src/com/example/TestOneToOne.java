package com.example;

import java.time.LocalDate;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class TestOneToOne {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		User user1 = new User(123, "Ajay", LocalDate.parse("1998-10-15"));
		User user2 = new User(456, "Brad", LocalDate.parse("1997-11-25"));

		Passport passport1 = new Passport("A123", LocalDate.now(), LocalDate.now().plusYears(10));
		passport1.setUser(user1);
		Passport passport2 = new Passport("B123", LocalDate.now(), LocalDate.now().plusYears(10));
		passport2.setUser(user2);
		
		// persist user first & then passport
		session.persist(user1);
		session.persist(passport1);
		session.persist(user2);
		session.persist(passport2);
		
		transaction.commit();
		System.out.println("DONE.....");
		
		HibernateUtil.close();
	}
}
