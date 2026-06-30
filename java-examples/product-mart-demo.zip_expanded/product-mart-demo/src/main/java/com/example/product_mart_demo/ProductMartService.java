package com.example.product_mart_demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class ProductMartService {

	@Autowired
	RestTemplate template;
	
	// If remote service is down fallback method is called
	// name=findPort is required to monitor which method is failing, we are going to use it in application.properties
	@CircuitBreaker(name = "findPort", fallbackMethod = "findAlternatePort")
	public String findRemotePort() {
		String URL = "http://PRODUCT-CATALOGUE-DEMO/mainCatalogue/port";
		System.out.println("****** A call is made to the Remote Microservice *****");
		String result = template.getForObject(URL, String.class);
		return result;
	}
	
	public String findAlternatePort(Throwable throwable) {
		System.out.println("***** An alternate port becaues remote service is down ******");
		return "80";
	}
}
