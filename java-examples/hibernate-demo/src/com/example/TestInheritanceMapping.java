package com.example;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class TestInheritanceMapping {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		// create objects for Worker, PermanentWorker, ContractEmployee
		Worker worker = new Worker(1, "Ajay");
		session.persist(worker);
		PermanentWorker permanentWorker = new PermanentWorker(2, "Brad", 500000);
		session.persist(permanentWorker);
		ContractEmployee contractEmployee = new ContractEmployee(3, "Charles", "EduTech", 3000, 20);
		session.persist(contractEmployee);
		System.out.println("All data is saved..");
		transaction.commit();
		HibernateUtil.close();
	}
}
