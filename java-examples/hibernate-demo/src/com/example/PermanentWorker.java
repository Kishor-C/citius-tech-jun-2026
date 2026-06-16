package com.example;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity
//below annotation creates primary key or foreign key in this entity depending on the inheritance strategy
//@PrimaryKeyJoinColumn(name = "id") 
@DiscriminatorValue("permanent")
public class PermanentWorker extends Worker {

	private double annualSalary;

	public PermanentWorker() {
		super();
		
	}
	public PermanentWorker(int id, String name, double annualSalary) {
		super(id, name);
		this.annualSalary = annualSalary;
	}
	@Override
	public String toString() {
		return "PermanentWorker [annualSalary=" + annualSalary + ", toString()=" + super.toString() + "]";
	}
	public double getAnnualSalary() {
		return annualSalary;
	}

	public void setAnnualSalary(double annualSalary) {
		this.annualSalary = annualSalary;
	}
	
	
}
