package com.examples;

public class DBUtil {
	private String username;
	private String password;
	public DBUtil() {
		System.out.println("DBUtil() created");
	}
	// create 2 constructors, setters & getters
	public DBUtil(String username, String password) {
		super();
		this.username = username;
		this.password = password;
		System.out.println("DBUtil(String, String)");
	}
	// we use username, password, url to connect to the DB
	public void getConnection() {
		System.out.println("Connected with username="+username+", password="+password);
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
