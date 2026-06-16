package com.examples;
class T implements Runnable {
	public void run() {
		for(int i = 1; i <= 500; i++) {
			System.out.println("run method i = "+i);
		}
	}
}
class TicketBooking implements Runnable {
	public void run() {
		try { 
			Thread.sleep(2000);
			System.out.println("Ticket booking completed");
		} catch(Exception e) {	e.printStackTrace(); }
	}
}
public class TestThreads {
	public static void main(String[] args) {
		TicketBooking ticket1 = new TicketBooking(); // main
		TicketBooking ticket2 = new TicketBooking(); // main
		System.out.println("---- sequential execution ------");  // main
		long start = System.currentTimeMillis(); // main
		ticket1.run(); // main
		ticket2.run(); // main
		long end = System.currentTimeMillis(); // main
		System.out.println("Time taken by single thread: "+(end - start)+" MS"); // main
		System.out.println("----- parallel execution -----"); // main
		Thread thread1 = new Thread(ticket1); // main
		Thread thread2 = new Thread(ticket2); // main
		start = System.currentTimeMillis(); // main
		thread1.start(); // thread -> cpu // main
		thread2.start(); // thread -> cpu // main
		try {
			thread1.join(); // main thread waits for child thread to complete // main
			thread2.join(); // main thread waits for child thread to complete // main
			end = System.currentTimeMillis(); // main
			System.out.println("Time taken by multiple threads: "+(end - start)+" MS"); // main
		} catch(Exception e) { // main
			e.printStackTrace(); // main
		}
	}
}
