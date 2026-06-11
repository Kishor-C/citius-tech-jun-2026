package com.examples;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TestIO {
	public static void main(String[] args) {
		try {
			FileWriter writer = new FileWriter("demo.txt", true);
			Scanner scan = new Scanner(System.in);
			System.out.println("Enter some input to write:-");
			String input = scan.nextLine();
			writer.write(input);
			writer.write('\n');
			writer.flush();
			writer.close();
			scan.close();
			System.out.println("DONE...");
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
