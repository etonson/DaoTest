package com.con;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
	private Connection con = null;
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/IssueTrace";
	private static final String USER = "sa";
	private static final String PASSWORD = "Aa123456";

	public DatabaseConnection() throws Exception {
		Class.forName(DRIVER);
		con = DriverManager.getConnection(URL,USER,PASSWORD);
	}
	public Connection getConnection()throws Exception{ 
		return con; 
		} 
	public void close()throws Exception{ 
		if(con!=null){ 
		con.close(); 
		} 
}
}