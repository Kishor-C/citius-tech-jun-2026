package com.example.product_catalogue_demo.beans;

/*
 * A record is immutable once created it can't be modified
 */
public record Product(String name, double price) {
	// explicit declaration of default constructor
	// in Record we must explicitly call the existing constructor used in the Record
	public Product() {
		this("", 0.0);
	}
}
