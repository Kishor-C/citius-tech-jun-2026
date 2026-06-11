package com.examples;

import java.util.List;

public interface StudentRepo {
	// provide methods to manage students
	// store the student
	void save(Student student);
	// return all the students in List
	List<Student> findAll();
	// return the student based on id
	Student findById(int rollNo) throws StudentNotFoundException;
	// delete the student based on id
	void deleteById(int rollNo);
}
