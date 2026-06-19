package com.examples.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.examples.dao.ProfileDao;
import com.examples.service.ProfileServiceImpl;

public class TestController {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		// accessing the service layer
		ProfileServiceImpl service = (ProfileServiceImpl)context.getBean("profileServiceImpl");
		service.createProfile();
		// accessing the dao layer - not correct if its a real controller
		ProfileDao dao = context.getBean(ProfileDao.class);
		dao.save();
		/*
		 * Create another implementation to the ProfileDao with @Repository
		 * run the main method
		 */
	}
}
