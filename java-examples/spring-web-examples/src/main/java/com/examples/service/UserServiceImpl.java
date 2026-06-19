package com.examples.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examples.dao.UserDao;
import com.examples.model.User;

@Service
public class UserServiceImpl implements UserService {

	private UserDao userDao;
	
	@Autowired
	public UserServiceImpl(UserDao userDao) {
		this.userDao = userDao;
	}
	@Override
	public int createUser(User user) {
		if(user != null) {
			return userDao.save(user);
		}
		throw new RuntimeException("Registration Failed due to invalid data");
	}
	@Override
	public User fetchUser(int id) {
		// returns the data if present else throws the exception
		return userDao.findById(id).orElseThrow(() -> new RuntimeException("User with and id not found: "+id));
	}
	@Override
	public List<User> fetchUsers() {
		List<User> list = userDao.findAll();
		return list;
	}
	@Override
	public void removeUser(int id) {
		User user = fetchUser(id); // if not found throws exception
		userDao.deleteById(user.getId());
	}
	@Override
	public User editUser(int id, User user) {
		return null;
	}
	
}
