package com.examples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		//2nd step - establish connection
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/citius_db", "root", "root");
		return connection;
	}
}
