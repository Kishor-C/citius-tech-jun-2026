package com.examples;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

public class TestJdbc {
	public static void main(String[] args) {
		try {
			Scanner scan = new Scanner(System.in);
			//1st step - loading the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			//2nd step - establish connection
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/citius_db", "root", "root");
			//3rd step - creating the statement
			String insertQuery = "insert into profile(name,password,dob,phone) values(?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(insertQuery);
			System.out.println("Enter name, password, dob in (yyyy-MM-dd) format and phone in this order");
			statement.setString(1, scan.next()); // sets 1st ? value i.e., to the name column
			statement.setString(2, scan.next()); // sets 2nd ? value 
			// we don't have setLocalDate in statement because LocalDate released in JDK8
			LocalDate dob = LocalDate.parse(scan.next());
			statement.setDate(3, Date.valueOf(dob)); // setDate accepts LocalDate using java.sql.Date.valueOf(LocalDate)
			statement.setLong(4, scan.nextLong());
			//4th step - execute the statement
			int rows = statement.executeUpdate();
			System.out.println("Rows updated: "+rows);
			//5th step - closing the resources
			statement.close();
			connection.close();
			scan.close();
		} catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
