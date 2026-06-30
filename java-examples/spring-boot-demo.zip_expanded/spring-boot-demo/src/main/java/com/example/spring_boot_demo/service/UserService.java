package com.example.spring_boot_demo.service;
/*
 * Service layer interface
 */

import java.time.LocalDate;
import java.util.List;

import com.example.spring_boot_demo.model.User;

public interface UserService {
	public User createUser(User user);
	public List<User> fetchUsers();
	public List<User> fetchUsersByDob(LocalDate dob);
	public List<User> fetchUsersByNameAndDob(String name, LocalDate dob);
	public User fetchUser(Integer id);
	public User edit(Integer id, User user);
	public void deleteUser(Integer id);
}
