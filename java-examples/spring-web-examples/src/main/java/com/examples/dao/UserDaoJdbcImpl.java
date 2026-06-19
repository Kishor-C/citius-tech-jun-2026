package com.examples.dao;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.examples.model.User;

@Repository
public class UserDaoJdbcImpl implements UserDao {

	private JdbcTemplate jdbc;
	
	@Autowired
	public UserDaoJdbcImpl(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}
	
	@Override
	public int save(User user) {
		final String INSERT_QUERY = "insert into user(id, name, dob) values (?,?,?)";
		return jdbc.update(INSERT_QUERY, user.getId(), user.getName(), Date.valueOf(user.getDob()));
	}

	@Override
	public List<User> findAll() {
		final String SELECT_ALL = "select * from user";
		List<User> users = jdbc.query(SELECT_ALL, 
				(rs, rowNum) -> new User(rs.getInt("ID"), rs.getString("NAME"), rs.getDate("DOB").toLocalDate()));
		return users;
	}

	@Override
	public void deleteById(int id) {
		final String DELETE_ID = "delete from user where id = ?";
		// update returns 0 if no data, you can throw exception if update returns 0 and handle at the client-side
		// if update returns 1 then its deleted
		jdbc.update(DELETE_ID, id);
	}

	@Override
	public Optional<User> findById(int id) {
		try { 
			final String SELECT_ID = "select * from user where id = ?";
			// queryForObject(sql-query, row-mapper, ..args)
			User user = jdbc.queryForObject(SELECT_ID, 
					(rs, rowNum) -> new User(rs.getInt("ID"), rs.getString("NAME"), rs.getDate("DOB").toLocalDate()), 
					id);
			return Optional.of(user);
		} catch(RuntimeException e) {
			// queryForObject throws EmptyResultException if no result is found
			return Optional.empty();
		}
	}

	@Override
	public User update(int id, User user) {
		// TODO Auto-generated method stub
		return null;
	}

}
