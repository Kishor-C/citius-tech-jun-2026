package com.example.spring_boot_demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring_boot_demo.model.User;
import com.example.spring_boot_demo.service.UserService;

@RestController
@RequestMapping("/api")
public class MyApi {

	@Autowired
	private UserService userService;

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> createUser(@RequestBody User user) {
		User created = userService.createUser(user);
		return ResponseEntity.status(201).body(created);
	}
	@GetMapping
	public ResponseEntity<Object> getUsers() {
		List<User> list = userService.fetchUsers();
		return ResponseEntity.ok(list);
	}
	@GetMapping(path = "/{id}")
	public ResponseEntity<Object> getUser(@PathVariable Integer id) {
		try { 
			User user = userService.fetchUser(id); 
		return ResponseEntity.ok(user);
		} catch(RuntimeException e) {
			Map<String, String> error = Map.of("message", e.getMessage());
			return ResponseEntity.status(404).body(error);
		}
	}
}
