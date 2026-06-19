package com.examples.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.examples.model.User;
import com.examples.service.UserService;

/*
 * Controller handles the request ->[service -> dao ->] response
 * since response will have java data, in Spring MVC we must use
 * ModelAndView object which passes model to the view (JSP)
 */
@Controller
@RequestMapping(path = "/myresource")
public class MyResource {

	private UserService userService;
	
	@Autowired
	public MyResource(UserService userService) {
		this.userService = userService;
	}
	@RequestMapping(path = "/users", method = RequestMethod.GET)
	public ModelAndView findAllUsers() {
		List<User> list = userService.fetchUsers();
		ModelAndView modelView = new ModelAndView("display", "users", list);
		return modelView;
	}
	
	
	@RequestMapping(path = "/test", method = RequestMethod.GET)
	public ModelAndView greet() {
		//ModelAndView stores Model and View
		//ModelAndView(viewName, modelName, model)
		ModelAndView modelView = new ModelAndView("welcome", "user", "Kishor");
		return modelView;
	}
	@RequestMapping(path = "/greet", method = RequestMethod.POST)
	public ModelAndView greet(@RequestParam("userInput") String name) {
		//ModelAndView stores Model and View
		//ModelAndView(viewName, modelName, model)
		ModelAndView modelView = new ModelAndView("welcome", "user", name.toUpperCase());
		return modelView;
	}
}
