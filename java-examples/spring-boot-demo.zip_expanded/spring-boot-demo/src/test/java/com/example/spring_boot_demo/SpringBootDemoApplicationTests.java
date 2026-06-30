package com.example.spring_boot_demo;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.spring_boot_demo.controller.MyApi;
import com.example.spring_boot_demo.model.User;
import com.example.spring_boot_demo.service.UserService;

import tools.jackson.databind.ObjectMapper;
/*
 * Test environment creates object of MyApi but doesn't create
 * Service & DAO or other objects in the application
 */
@WebMvcTest(value = MyApi.class)
class SpringBootDemoApplicationTests {

	 //MockMvc - this object simulates browser or clients to send request
	// it can send HTTP requests 
	@Autowired
	MockMvc mockMvc;
	// Since controller is accessing service object we need to mock service object
	// if you send request to /api/1 -> it must return JSON data having user information
	@MockitoBean
	private UserService service;
	@Autowired
	private ObjectMapper objectMapper;
	
	@Test
	public void testGetUserById() throws Exception {
		//create the java object that is returned by the service when you send request for /api/1
		User user = new User();
		user.setId(1);
		//Service layer returns the above user object for /api/1
		Mockito.when(service.fetchUser(1)).thenReturn(user);
		//sending GET request for /api/1
		// expecting the response content to have JSON property id
		mockMvc.perform(MockMvcRequestBuilders.get("/api/1"))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$.id", CoreMatchers.is(1)));
	}
	// write one more test for /api POST - mock the createUser() and return the fake user 
	// so that response must have json data with id and also expected result must have status code 201
	@Test
	public void testStoreUser() throws Exception {
		User user1 = new User();
		user1.setName("Raj");
		user1.setDob(LocalDate.now());
		User user2 = new User();
		user2.setId(1);
		user2.setName("Raj");
		user2.setDob(LocalDate.now());
		Mockito.when(service.createUser(user1)).thenReturn(user2);
		mockMvc
		.perform(
				post("/api").contentType(MediaType.APPLICATION_JSON_VALUE)
				.content("{\"name\":\"Raj\"}")
				)
		.andExpect(status().isCreated())
		.andExpect(jsonPath("$.id", is(1)));
	}
}
