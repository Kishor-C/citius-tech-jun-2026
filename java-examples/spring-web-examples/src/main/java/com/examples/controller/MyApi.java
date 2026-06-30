package com.examples.controller;

import java.util.List;
import java.util.Map;

import javax.print.attribute.standard.Media;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.examples.model.User;
import com.examples.service.UserService;

/*
 * Rest controller also use front controller
 */
@RestController
@RequestMapping(path = "/api")
// The URL client must use is http://localhost:8080/spring/api
public class MyApi {

	private UserService userService;
	
	@Autowired
	public MyApi(UserService userService) {
		this.userService = userService;
	}
	@RequestMapping(path = "/users", 
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<Object> saveUser(@RequestBody User user) {
		int status = userService.createUser(user);
		return ResponseEntity.status(201).body("Saved "+status+" data");
	}
	// user[id=100,name=Ajay, dob=2001-10-16] -> {"id":100, "name":"Ajay", "dob":"2001-10-16"}
	//ResponseEntity must be the return type of a webservice
	@RequestMapping(path = "/users", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> fetchUsers() {
		List<User> list = userService.fetchUsers();
		// ok means 200 status code and it carries list in the response body
		ResponseEntity<Object> response = ResponseEntity.ok(list);
		return response;
	}
	@RequestMapping(path = "/users/{userId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> fetchUser(@PathVariable("userId") int id) {
		try {
			User user = userService.fetchUser(id);
			return ResponseEntity.ok(user); // 200 - { }
		} catch(RuntimeException e) {
			Map<String, String> errorMap = Map.of("error", e.getMessage());
			return ResponseEntity.status(404).body(errorMap);
		}
	}
}
