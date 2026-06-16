package com.example;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Passport {
	@Id
	private String passportNumber;
	private LocalDate issueDate;
	private LocalDate expiryDate;
	
	// without passport user must not exist hence we create User in passport
	@OneToOne // joins passport & user table and maintains the user object in the passport object
	@JoinColumn(name = "user_id") // foreign key column in the passport that refers to the primary key of user table
	private User user;
	
	public Passport() {
		super();
	}
	public Passport(String passportNumber, LocalDate issueDate, LocalDate expiryDate) {
		super();
		this.passportNumber = passportNumber;
		this.issueDate = issueDate;
		this.expiryDate = expiryDate;
	}
	@Override
	public String toString() {
		return "Passport [passportNumber=" + passportNumber + ", issueDate=" + issueDate + ", expiryDate=" + expiryDate
				+ "]";
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getPassportNumber() {
		return passportNumber;
	}
	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}
	public LocalDate getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(LocalDate issueDate) {
		this.issueDate = issueDate;
	}
	public LocalDate getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}
	
	
	
}
