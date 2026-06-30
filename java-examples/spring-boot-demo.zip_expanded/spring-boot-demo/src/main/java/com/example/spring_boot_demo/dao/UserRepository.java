package com.example.spring_boot_demo.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.spring_boot_demo.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	public List<User> findByDob(LocalDate dob);
	// below method is applied when name and dob both should match
	// we don't have to create query, we must use 
	// the method name starting with findBy followed by property 
	// then followed by And and lastly followed by another property
	public List<User> findByNameAndDob(String name, LocalDate dob);
	
	
}
