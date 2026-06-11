package com.examples;

import java.util.List;
import java.util.Scanner;

public class TestMenu {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		StudentRepo repo = new StudentManagerFileList();
		int option = 0;
		do {
			System.out.println("1: Add 2: Find By Id 3: Find All 4: Delete By Id 5: Update Percentage 6: Sorting 7: Exit");
			option = scan.nextInt();
			switch(option) {
			case 1 : { 
				System.out.println("Enter roll no");
				int rollNo = scan.nextInt();
				System.out.println("Enter name");
				String name = scan.next();
				System.out.println("Enter percentage");
				double percentage = scan.nextDouble();
				Student student = new Student(rollNo, name, percentage);
				repo.save(student);
				System.out.println("**********************************************");
				break;
			}
			// implement case 2 
			case 2 : {
				System.out.println("Enter roll no.");
				try {
					Student student = repo.findById(scan.nextInt());
					System.out.println(student.getName());
				} catch(StudentNotFoundException e) {
					//e.printStackTrace();
					System.err.println(e.getMessage());
				} 
				break;
			}
			case 3 : { 
				List<Student> list = repo.findAll();
				for(Student student : list) {
					System.out.println(student);
				}
				System.out.println("**********************************************");
				break;
			}
			case 6: {
				System.out.println("1: RollNo in Asc 2: Roll No in Desc 3: Name in Asc 4: Name in Desc 5: Percentage in Asc 6: Percentage in Desc");
				int sortOption = scan.nextInt();
				List<Student> list = repo.findAll();
				switch(sortOption) {
				case 1 : {
					list.sort((x, y) -> Integer.compare(x.getRollNo(), y.getRollNo()));
					break; 
					}
				case 3 : {
					list.sort((x, y) -> x.getName().compareTo(y.getName()));
					break; 
					}
				}
				for(Student student : list) {
					System.out.println(student);
				}
			}
			}
		} while(option != 7);
		scan.close();
	}

}
