package com.example.product_catalogue_demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.product_catalogue_demo.beans.Product;
import com.example.product_catalogue_demo.service.ProductServiceImpl;

@RestController
@RequestMapping("/mainCatalogue")
public class ProductCatalogueController {
	@Autowired
	private ProductServiceImpl productService;
	
	@Value("${server.port}")
	private String port;
	
	//@Value("${message}")
	private String message;
	
	@GetMapping(path = "/config")
	public String getMessage() {
		return message;
	}
	
	@GetMapping(path = "/port")
	public String getInstancePort() {
		return port;
	}
	
	@GetMapping
	public ResponseEntity<Object> getProducts() {
		List<Product> list = productService.getProducts();
		return ResponseEntity.status(200).body(list);
	}
	
}
