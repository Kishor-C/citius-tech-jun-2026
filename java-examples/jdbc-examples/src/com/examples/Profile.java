package com.examples;
/*
 * Model to maintain profile data
 */

import java.time.LocalDate;

public class Profile {
	private int id;
	private String name;
	private String password;
	private LocalDate dob;
	private long phone;
	// generate 3 constructors: default, 4 parameters & 5 parameters
	public Profile() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Profile(String name, String password, LocalDate dob, long phone) {
		super();
		this.name = name;
		this.password = password;
		this.dob = dob;
		this.phone = phone;
	}
	public Profile(int id, String name, String password, LocalDate dob, long phone) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.dob = dob;
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "Profile [id=" + id + ", name=" + name + ", password=" + password + ", dob=" + dob + ", phone=" + phone
				+ "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	
	
}
