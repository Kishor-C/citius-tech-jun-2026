package com.examples.service;

import java.util.List;

import com.examples.model.User;

public interface UserService {
	public int createUser(User user);
	public User fetchUser(int id);
	public List<User> fetchUsers();
	public void removeUser(int id);
	public User editUser(int id, User user);
	// some extra methods other than CRUD
	// add mulitple users in a batch : addUsers(List<User> users)
}
