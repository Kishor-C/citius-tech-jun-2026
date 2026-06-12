package com.examples;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

public class ProfileJdbcDAO implements ProfileDAO {
	/*
	 * save method that accepts profile and returns saved profile
	 */
	@Override
	public Profile save(Profile profile) {
		Profile saved = null;
		try {
			Connection connection = DBUtil.getConnection();
			String insertQuery = "insert into profile(name,password,dob,phone) values(?,?,?,?)";
			// this statement takes query as well as an input to store the generate key 
			PreparedStatement statement = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, profile.getName());
			statement.setString(2, profile.getPassword());
			statement.setDate(3, Date.valueOf(profile.getDob()));
			statement.setLong(4, profile.getPhone());
			int rows = statement.executeUpdate();
			if(rows > 0) {
				// since statement generates the primary key because of Statement.RETURN_GENERATED_KEYS
				ResultSet result = statement.getGeneratedKeys();
				if(result.next()) {
					int key = result.getInt(1); // generated key will be retrieved
					profile.setId(key);
					saved = profile;
				}
				result.close();
			} else {
				throw new RuntimeException("Failed to store");
			}
			statement.close();
			connection.close();
		} catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return saved;
	}
	@Override
	public List<Profile> findAll() {
		return null;
	}
	@Override
	public Optional<Profile> findById(int id) {
		return Optional.empty();
	}
	@Override
	public void deleteById(int id) {
		
	}
	@Override
	public Profile update(int id, Profile profile) {
		return null;
	}

}
