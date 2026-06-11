package com.examples;

interface Vehicle {
	void mileage(); // print mileage
	void wheels(); // print wheels
}
abstract class Bike implements Vehicle {
	@Override
	public void wheels() { 
		System.out.println("No. of wheels is 2");
	}
}
class RoyalEnfield extends Bike {
	@Override
	public void mileage() {
		System.out.println("Royal Enfield mileage is 20kmpl");
	}
}
class KTM extends Bike {
	@Override
	public void mileage() {
		System.out.println("KTM mileage is 30kmpl");
	}
}
// implement classes like Car, Innova, Brezza
public class TestAbstraction2 {
	public static void main(String[] args) {
		RoyalEnfield enfield = new RoyalEnfield();
		KTM ktm = new KTM();
		printFeatures(enfield);
		printFeatures(ktm);
	}
	public static void printFeatures(Vehicle vehicle) {
		vehicle.mileage();
		vehicle.wheels();
		System.out.println("****************************");
	}
}
