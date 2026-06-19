package com.examples.dao;

import org.springframework.stereotype.Repository;

@Repository
/*
 * Spring creates an object with an id same as the class name, but the id begins in lowercase
 * i.e., profileDaoTest
 */
public class ProfileDaoTest implements ProfileDao {

	@Override
	public void save() {
		System.out.println("saves in the test table");
	}

}
