package com.examples;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class TestCollection {
	public static void main(String[] args) {
		
		Student student1 = new Student(5, "Raj", 75.0);
		Student student2 = new Student(1, "Vijay", 65.0);
		Student student3 = new Student(3, "Frank", 55.0);
		Student student4 = new Student(4, "David", 85.0);
		Student student5 = new Student(2, "Gourav", 95.0);
		
		// anonymous class for Comparator
		Comparator<Student> sortByMarksAsc = (o1, o2) ->  Double.compare(o1.getPercentage(), o2.getPercentage());
		Comparator<Student> sortByMarksDesc = (o1, o2) -> Double.compare(o2.getPercentage(), o1.getPercentage());	
		Comparator<Student> sortByRollNoDesc = (o1, o2) -> Integer.compare(o2.getRollNo(), o1.getRollNo());
			
		Set<Student> students = new TreeSet<Student>(sortByRollNoDesc);
		students.add(student1); // 5, 5 -> 0
		students.add(student2); // 1, 5 -> -1
		students.add(student3); // 3, 5 -> 3, 1 -> 
		students.add(student4); // 4, 5 -> 4, 3 -> 
		students.add(student5); // 2, 5 -> 2, 4 -> 2, 3
	
		for(Student student : students) {
			System.out.println(student);
		}
		System.out.println("*******************List Sorting**************************");
		// we have a sort method in the List also that accepts Comparator
		List<Student> studentsList = new ArrayList<Student>(students);
		studentsList.sort(sortByMarksAsc);
		for(Student student : studentsList) {
			System.out.println(student);
		}
		
	}
}
