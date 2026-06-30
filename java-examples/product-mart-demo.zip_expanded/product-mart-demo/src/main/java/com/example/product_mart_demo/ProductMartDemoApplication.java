package com.example.product_mart_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ProductMartDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductMartDemoApplication.class, args);
	}
	/*
	 * @Bean method is automatically executed and the object returned
	 * is registered in the spring container
	 * @LoadBalanced - query service discovery using the instance-id of the
	 * remote microserivce
	 * 
	 */
	@Bean
	@LoadBalanced
	RestTemplate template() {
		return new RestTemplate();
	}
	/*
	 * Activity: Call the Microservice returning list of products and apply 10% discount and display discounted
	 * price of each product
	 */

}
