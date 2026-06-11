package com.examples;
// it is a contract
interface Payment { 
	void pay(); // public abstract void pay();
}
// credit card payment
class CreditCardPayment implements Payment {
	public void pay() {	System.out.println("payment done with Credit Card");  }
}
// upi payment
class UPIPayment implements Payment {
	public void pay() {	System.out.println("payment done through UPI"); }
}
// wallet payment
class WalletPayment implements Payment { 
	public void pay() {	System.out.println("payment done through Wallet"); }
}
public class TestAbstraction {
	// developer instantiates the object and passes to the payment processor
	public static void main(String[] args) {
		CreditCardPayment credit = new CreditCardPayment(); // user using credit card
		process(credit);
		UPIPayment upi = new UPIPayment(); // user using upi
		process(upi);
		WalletPayment wallet = new WalletPayment(); // user using wallet
		process(wallet);
	}
	// payment processor used by the client
	public static void process(Payment payment1) {
		payment1.pay();
		System.out.println("**********************************");
	}
}
