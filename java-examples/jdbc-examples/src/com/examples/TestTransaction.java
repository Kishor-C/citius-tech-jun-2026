package com.examples;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

public class TestTransaction {
	public static void main(String[] args) {
		try {
			Scanner scan = new Scanner(System.in);
			Connection connection = DBUtil.getConnection();
			connection.setAutoCommit(false);
			String insertQuery = "insert into profile(name,password,dob,phone) values(?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(insertQuery);
			System.out.println("Enter 5 records to insert");
			for(int i = 1; i <= 5; i++) {
				System.out.println("Enter name, password, dob(yyyy-MM-dd) phone in the same order");
				statement.setString(1, scan.next());
				statement.setString(2, scan.next());
				statement.setDate(3, Date.valueOf(LocalDate.parse(scan.next())));
				statement.setLong(4, scan.nextLong());
				statement.executeUpdate();
				System.out.println("Inserted Record: "+i);
				if(i == 3) {
					connection.rollback();
					System.out.println("Rolledback at record "+i);
				}
			}
			connection.commit();
			statement.close();
			connection.close();
			scan.close();
		} catch (ClassNotFoundException | SQLException  e) {
			e.printStackTrace();
		}
	}
}
