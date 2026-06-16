package com.example;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity
//below annotation creates primary key or foreign key in this entity depending on the inheritance strategy
//@PrimaryKeyJoinColumn(name = "id") 
@DiscriminatorValue("contract")
public class ContractEmployee extends Worker {

	private String vendorName;
	private double hourlyRate;
	private int totalhours;
	
	public ContractEmployee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ContractEmployee(int id, String name, String vendorName, double hourlyRate, int totalhours) {
		super(id, name);
		this.vendorName = vendorName;
		this.hourlyRate = hourlyRate;
		this.totalhours = totalhours;
	}
	@Override
	public String toString() {
		return "ContractEmployee [vendorName=" + vendorName + ", hourlyRate=" + hourlyRate + ", totalhours="
				+ totalhours + ", toString()=" + super.toString() + "]";
	}
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	public double getHourlyRate() {
		return hourlyRate;
	}
	public void setHourlyRate(double hourlyRate) {
		this.hourlyRate = hourlyRate;
	}
	public int getTotalhours() {
		return totalhours;
	}
	public void setTotalhours(int totalhours) {
		this.totalhours = totalhours;
	}
	
}
