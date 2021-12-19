package com.company.repository;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectToDB {
	private Connection con = null;
	
	public void connectDB() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(Exception ex) {
			System.out.println("JDBC not working");
		}
		
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/labor5", "root", "root");
		} catch(Exception ex) {
			System.out.println("Can't connect to DB");
		}
	}

	public Connection getConnection() {
		// TODO Auto-generated method stub
		return con;
	}

}
