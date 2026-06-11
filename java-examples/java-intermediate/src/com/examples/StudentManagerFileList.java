package com.examples;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class StudentManagerFileList implements StudentRepo {
	// manage the student objects in the List
	private static List<Student> students = new ArrayList<Student>();

	@Override
	public void save(Student student) {
		students.add(student);
		try {
			FileOutputStream fileOutput = new FileOutputStream("studentlist.ser");
			ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);
			// writes the entire list having student
			objectOutput.writeObject(students);
			objectOutput.flush();
			objectOutput.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Student> findAll() {
		// read the list from the file
		try { 
			FileInputStream fileInput = new FileInputStream("studentlist.ser");
			ObjectInputStream objectInput = new ObjectInputStream(fileInput);
			// typecast because writeObject writes everything in Object type
			// hence while reading we must convert to List<Student>
			students = (List<Student>)objectInput.readObject();
			objectInput.close();
			return students;
		} catch(IOException | ClassNotFoundException  e) {
			e.printStackTrace();
			throw new RuntimeException("File doesn't exist");
		}
	}
	@Override
	public Student findById(int rollNo) throws StudentNotFoundException {
		try { 
			FileInputStream fileInput = new FileInputStream("studentlist.ser");
			ObjectInputStream objectInput = new ObjectInputStream(fileInput);
			// typecast because writeObject writes everything in Object type
			// hence while reading we must convert to List<Student>
			students = (List<Student>)objectInput.readObject();
			objectInput.close();
			//return students;
		} catch(IOException | ClassNotFoundException  e) {
			e.printStackTrace();
			throw new RuntimeException("File doesn't exist");
		}
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
