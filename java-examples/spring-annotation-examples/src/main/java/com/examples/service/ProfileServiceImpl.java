package com.examples.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.examples.dao.ProfileDao;

@Service
/*
 * Spring creates an object with an id same as the class name but begins with lowercase
 * i.e., profileServiceImpl
 */
public class ProfileServiceImpl {
	// @Autowired is used to tell spring to inject the object matching to the type
	
	private ProfileDao profileDao;

	@Autowired
	// supplies the object of ProfileDao type through setter injection
	public void setProfileDao(@Qualifier("profileDaoTest") ProfileDao profileDao) {
		this.profileDao = profileDao;
	}
	
	// if profileDao is initialized then we must able to access its method
	public void createProfile() {
		profileDao.save();
		System.out.println("createProfile() invoked save() from ProfileDao");
	}
}
