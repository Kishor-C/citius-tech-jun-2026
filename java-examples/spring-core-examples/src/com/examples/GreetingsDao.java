package com.examples;

public class GreetingsDao {
	private DBUtil dbutil;

	public DBUtil getDbutil() {
		return dbutil;
	}

	public void setDbutil(DBUtil dbutil) {
		this.dbutil = dbutil;
	}
	
	public void save() {
		dbutil.getConnection();
		System.out.println("save() method is executed after getting connection");
	}
}
/*
 * Configure GreetingsDao in the xml and the property dbutil must use ref attribute in the 
 * property tag, provide any one of the bean id to the ref attribute i.e.,
 * <property name = "dbutil" ref = "util"/> This supplies DBUtil object to GreetingDao
 * From main get the GreetingsDao object and call the save method,
 * change the ref value to utilTest and run the main you will see another DBUtil used by the
 * GreetingsDao this makes GreetingsDao to use any object of DBUtil without changing the
 * GreetingsDao
 * 
 */
