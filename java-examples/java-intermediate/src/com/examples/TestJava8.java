package com.examples;

import java.util.List;

public class TestJava8 {
	public static void main(String[] args) {
		List<Integer> numbers = List.of(1, 2, 3, 4, 5); 
		System.out.println("*** Consumer ******");
		numbers.forEach(n -> System.out.println(n));
		System.out.println("****Filtering****");
		numbers.stream().filter(n -> n % 2 == 0).forEach(n -> System.out.println(n));
		System.out.println("***Transformation****");
		numbers.stream().map(n -> n * 0.9).forEach(n -> System.out.println(n));
		// Streams on Student
		Student student1 = new Student(5, "Raj", 75.0);
		Student student2 = new Student(1, "Vijay", 65.0);
		Student student3 = new Student(3, "Frank", 55.0);
		Student student4 = new Student(4, "David", 85.0);
		Student student5 = new Student(2, "Gourav", 95.0);
		List<Student> students = List.of(student1, student2, student3, student4, student5);
		students.stream().filter(s -> s.getPercentage() > 80.0).forEach(s -> System.out.println(s));
		// in stream we can collect and store the data in a new collection
		System.out.println("*****Transform and store only names in a new list *****");
		List<String> names = students.stream().map(s -> s.getName()).toList();
		System.out.println(names);
		// finding the top rank student
		Student top = students.stream().max((x, y) -> Double.compare(x.getPercentage(), y.getPercentage())).get();
		System.out.println(top);
		
	}
}
