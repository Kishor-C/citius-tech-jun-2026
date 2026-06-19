package com.examples.service;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.examples.dao.UserDao;
import com.examples.model.User;

public class UserServiceImplTest {
	/*
	 * Treat this as a service layer
	 * that has methods to invoke all the methods of UserDao
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("1: Save 2: Find By Id 3: Find All 4: Update 5: Delete By ID 6: Exit");
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		UserDao userDao = context.getBean(UserDao.class);
		int option = scan.nextInt();
		if(option == 1) {
			System.out.println("Enter id, name, dob(yyyy-MM-dd)");
			User user = new User(scan.nextInt(), scan.next(), LocalDate.parse(scan.next()));
			int status = userDao.save(user);
			System.out.println("Row affected: "+status);
		}
		if(option == 2) {
			System.out.println("Enter id");
			int id = scan.nextInt();
			Optional<User> optional = userDao.findById(id);
			if(optional.isEmpty()) System.out.println("No data found");
			else System.out.println(optional.get());
		}
		if(option == 3) {
			userDao.findAll().stream().forEach(user -> System.out.println(user));
		}
		if(option == 4) {
			// implement update which asks what to update name or dob
			// based on that DAO layer must work
		}
		if(option == 5) {
			System.out.println("Enter id");
			int id = scan.nextInt();
			userDao.deleteById(id);
			userDao.findAll().stream().forEach(user -> System.out.println(user));
		}
	}

}
