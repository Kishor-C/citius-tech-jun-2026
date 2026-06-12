package com.examples;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class TestSelect {

	public static void main(String[] args) {
		try {
			Connection connection = DBUtil.getConnection();
			//Statement statement = connection.createStatement();
			Scanner scan = new Scanner(System.in);
			System.out.println("Enter name and password");
			String name = scan.nextLine();
			String password = scan.nextLine();
			String query = "select * from profile where name = ? and password = ?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, name);
			statement.setString(2, password);
			ResultSet result = statement.executeQuery();
			// next() method checks if record is present and iterates
			while(result.next()) {
				// we are extracting value of every row by mentioning column name in the getter method of ResultSet
				System.out.println("Id = "+result.getInt("ID"));
				System.out.println("Name = "+result.getString("NAME"));
				System.out.println("Password = "+result.getString("PASSWORD"));
				System.out.println("Dob = "+result.getDate("DOB").toLocalDate());
				System.out.println("Phone = "+result.getLong("PHONE"));
			}
			result.close();
			statement.close();
			connection.close();
			scan.close();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
