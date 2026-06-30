package com.example.product_catalogue_demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.product_catalogue_demo.beans.Product;

@Service
public class ProductServiceImpl {

	public List<Product> getProducts() {
		List<Product> list = List.of(
				new Product("Shoes", 2500.0),
				new Product("Shirts", 2000.0),
				new Product("Watch", 5000.0),
				new Product("Mobile", 12000.0)
				);
		return list;
	}
}
