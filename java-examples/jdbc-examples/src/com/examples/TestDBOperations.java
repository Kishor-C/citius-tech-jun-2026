package com.examples;

import java.time.LocalDate;
import java.util.Scanner;

public class TestDBOperations {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter name, password, dob in (yyyy-MM-dd) format and phone in this order");
		Profile profile = new Profile(scanner.next(), scanner.next(), LocalDate.parse(scanner.next()), scanner.nextLong());
		// dao instance
		ProfileDAO dao = new ProfileJdbcDAO();
		// calling save method
		Profile savedEntity = dao.save(profile);
		System.out.println(savedEntity);
		scanner.close();
	}
}
