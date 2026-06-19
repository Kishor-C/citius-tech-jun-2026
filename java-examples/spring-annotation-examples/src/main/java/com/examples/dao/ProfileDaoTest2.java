package com.examples.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
@Primary
/*
 * Spring creates an object with an id same as the class name, but the id begins in lowercase
 * i.e., profileDaoTest2
 */
public class ProfileDaoTest2 implements ProfileDao {

	@Override
	public void save() {
		System.out.println("saves in the test table - Test2");
	}

}
