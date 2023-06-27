package com.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	public static Connection dbConn() {
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/myDatabase";
		String user = "root";
		String password = "root";
		
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, user, password);
			return con;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
