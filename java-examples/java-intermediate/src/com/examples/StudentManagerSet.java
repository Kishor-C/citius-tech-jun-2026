package com.examples;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StudentManagerSet implements StudentRepo {

	private static Set<Student> students = new HashSet<Student>();
	@Override
	public void save(Student student) {
		students.add(student);
	}

	@Override
	public List<Student> findAll() {
		// copies all the students to a new list
		return new ArrayList<Student>(students);
	}

	@Override
	public Student findById(int rollNo) throws StudentNotFoundException {
		for(Student student : students) {
			if(student.getRollNo() == rollNo)
				return student;
		}
		throw new StudentNotFoundException("Student with an id "+rollNo+" not found");
	}

	@Override
	public void deleteById(int rollNo) {

	} 
}
