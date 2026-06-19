package com.examples;

class BookingTicket implements Runnable {

	private int counter = 1;
	@Override
	public synchronized void run() {
		String name = Thread.currentThread().getName();
		if(counter >= 1) {
			//process the payment & send the confirmation message
			System.out.println(name+" booked the ticket");
			counter--;
		} else {
			System.out.println(name+" try next time all tickets booked");
		}
	}
	
}

public class TestSynchronization {
	public static void main(String[] args) {
		BookingTicket ticket = new BookingTicket();
		new Thread(ticket, "Thread1").start();
		new Thread(ticket, "Thread2").start();
		new Thread(ticket, "Thread3").start();
		new Thread(ticket, "Thread4").start();
	}
}
