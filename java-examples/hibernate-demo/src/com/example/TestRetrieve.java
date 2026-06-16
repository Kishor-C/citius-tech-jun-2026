package com.example;

import java.util.List;

import org.hibernate.Session;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class TestRetrieve {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSession();
		// read the entity using primary key
		Employee employee = session.get(Employee.class, 1);
		System.out.println(employee);
		
		// CriteriaQuery - programmatically specifies we need to get Employee objects
		CriteriaQuery<Employee> query = session.getCriteriaBuilder().createQuery(Employee.class);
		// specifying we are getting employee objects from Employee entity
		query.from(Employee.class);
		// generate the result for the query
		List<Employee> list = session.createQuery(query).getResultList();
		
		list.forEach(item -> System.out.println(item));
		
		// CriteriaQuery for only getting names
		CriteriaBuilder builder = session.getCriteriaBuilder();
		// Query to get only String objects
		CriteriaQuery<String> query2 = builder.createQuery(String.class);
		// String objects form Employee entity
		Root<Employee> names = query2.from(Employee.class);
		// name property from the Employee entity
		query2.select(names.get("name"));
		// generate the result for the query
		List<String> namesList = session.createQuery(query2).getResultList();
		System.out.println(namesList);
		HibernateUtil.close();
	}
}
