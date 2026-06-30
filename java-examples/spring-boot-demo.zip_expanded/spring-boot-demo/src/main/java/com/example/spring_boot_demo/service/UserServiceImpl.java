package com.example.spring_boot_demo.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring_boot_demo.dao.UserRepository;
import com.example.spring_boot_demo.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;
	@Override
	public User createUser(User user) {
		return userRepo.save(user);
	}
	@Override
	public List<User> fetchUsers() {
		return userRepo.findAll();
	}
	@Override
	public List<User> fetchUsersByDob(LocalDate dob) {
		return userRepo.findByDob(dob);
	}
	@Override
	public List<User> fetchUsersByNameAndDob(String name, LocalDate dob) {
		return userRepo.findByNameAndDob(name, dob);
	}
	@Override
	public User fetchUser(Integer id) {
		return userRepo.findById(id).orElseThrow(() -> new RuntimeException("User not found : "+id));
	}
	@Override
	public User edit(Integer id, User user) {
		// We don't have update method in Repository, setting value to the entity updates
		User entity = fetchUser(id);
		if(!user.getName().equals(""))
			entity.setName(user.getName());
		if(user.getDob() != null) 
			entity.setDob(user.getDob());
		return entity;
	}
	@Override
	public void deleteUser(Integer id) {
		User user = fetchUser(id);
		userRepo.delete(user);
	}
}
