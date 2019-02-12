package org.kamil.invoice.domain.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseDao {
	
	private static DatabaseDao uniqueDb;
	
	Connection conn = null;
	public Statement stat = null;
	
	public DatabaseDao() {
		getStatement();
	}
	
	public static DatabaseDao getDb() {
		if(uniqueDb == null) {
			uniqueDb = new DatabaseDao();
		}
		return uniqueDb;
	}
	
	public Statement getStatement() {
		try {
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:invoice.db");
			stat = conn.createStatement();			
			System.out.println("Connection succesfull");
		} catch (SQLException e) {
			System.err.println("Database error: \n" + e.getMessage());
			System.exit(0);
		} catch (ClassNotFoundException e) {			
			e.printStackTrace();
		}
		
		return this.stat;
	}

}
