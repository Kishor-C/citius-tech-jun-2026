package com.example.product_mart_demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.product_mart_demo.beans.Product;

@RestController
@RequestMapping("/productMart")
public class ProductMartController {

	@Autowired
	private RestTemplate template;
	
	@Autowired
	ProductMartService service;
		
	@GetMapping(path = "/cbtest")
	public String getRemotePort() {
		return service.findRemotePort();
	}
	
	
	@GetMapping(path = "/products")
	public ResponseEntity<Object> getProducts() {
		String URL = "http://PRODUCT-CATALOGUE-DEMO/mainCatalogue";
		Product[] products = template.getForObject(URL, Product[].class);
		List<Product> list = Arrays.asList(products); // 2500, 2000
		List<Product> discountedList = list
				.stream()
				.map(item -> new Product(item.getName(), item.getPrice() * 0.95))
				.toList(); 
		Map<String, List<Product>> productMap = 
				Map.of("original", list, "discounted", discountedList);
		return ResponseEntity.ok(productMap);
	}
	
}
