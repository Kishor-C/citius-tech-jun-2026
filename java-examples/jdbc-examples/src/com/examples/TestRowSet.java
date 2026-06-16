package com.examples;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

public class TestRowSet {
	public static void main(String[] args) {
		try {
			JdbcRowSet rowset = RowSetProvider.newFactory().createJdbcRowSet();
			rowset.setUrl("jdbc:mysql://localhost:3306/citius_db");
			rowset.setUsername("root");
			rowset.setPassword("root");
			rowset.setCommand("select * from profile");
			rowset.execute();
			while(rowset.next()) {
				System.out.println(rowset.getString(2));
			}
			System.out.println("-------------------------");
			while(rowset.previous()) {
				System.out.println(rowset.getString(2));
			}
			rowset.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
