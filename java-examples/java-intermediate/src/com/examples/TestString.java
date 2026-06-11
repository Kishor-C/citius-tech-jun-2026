package com.examples;

public class TestString {
	public static void main(String[] args) {
		/*
		 * concat(), length(), indexOf(), charAt(), substring(), equals(), toUpperCase()...
		 */
		String email = "kishor1234@gmail.com";
		String password = "kishor1234@gmail.com";
		// equals - compares content, avoid using == to compare strings
		System.out.println("Equality: "+email.equals(password));
		System.out.println("Equality == : "+(email == password));
		String confirmPassword = "kishor1234".concat("@gmail.com");
		System.out.println("Confirm Password = "+confirmPassword);

		System.out.println("Equality: "+email.equals(confirmPassword));
		System.out.println("Equality == : "+(email == confirmPassword));
		// charAt - gives a character from a particular index
		char firstLetter = email.charAt(0);
		System.out.println("First Letter: "+firstLetter);
		// indexOf - gives the index of a character
		int index = email.indexOf('@');
		System.out.println("Index of @ is: "+index);
		String username = email.substring(0, index);
		System.out.println("Hi, "+username.toUpperCase());
		int lastIndex = email.lastIndexOf('.');
		String domain = email.substring(index + 1, lastIndex);
		System.out.println("Domain is: "+domain);
		//String - immutable
		String ifsc = "ICICI";
		String branch1 = ifsc.concat("001");
		String branch2 = ifsc.concat("002");
		System.out.println(ifsc + ", " +branch1 + ", "+branch2);
		//StringBuffer/StringBuilder - mutable
		StringBuilder builder = new StringBuilder("HDFC");
		System.out.println("Builder = "+builder);
		StringBuilder branch3 = builder.append("001");
		System.out.println("branch3 = "+branch3);
		StringBuilder branch4 = builder.append("002");
		System.out.println("branch4 = "+branch4);
	}
}
