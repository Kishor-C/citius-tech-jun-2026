package com.examples.dao;

import java.util.List;
import java.util.Optional;

import com.examples.model.User;

public interface UserDao {
	int save(User user);
	List<User> findAll();
	void deleteById(int id);
	Optional<User> findById(int id);
	User update(int id, User user);
}
