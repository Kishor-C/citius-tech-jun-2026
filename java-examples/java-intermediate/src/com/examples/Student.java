package com.examples;

import java.io.Serializable;
import java.util.Objects;

public class Student implements Comparable<Student>, Serializable {
	// rollNo, name, percentage
	private int rollNo;
	private String name;
	private double percentage;
	public Student() {
		super();
	}
	public Student(int rollNo, String name, double percentage) {
		super();
		this.rollNo = rollNo;
		this.name = name;
		this.percentage = percentage;
	}
	@Override
	public int compareTo(Student o) {
		return Integer.compare(this.rollNo, o.getRollNo());
		//return Double.compare(o.getPercentage(), this.percentage);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(rollNo);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return rollNo == other.rollNo;
	}
	// toString is automatically called when you print object
	@Override
	public String toString() {
		return "Student [rollNo=" + rollNo + ", name=" + name + ", percentage=" + percentage + "]";
	}
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPercentage() {
		return percentage;
	}
	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}
	
	
}
