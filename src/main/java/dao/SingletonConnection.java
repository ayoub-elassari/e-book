package dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;


public class SingletonConnection {
	private static Connection connection;
	
    
	static {
    	try {
			Class.forName("com.mysql.jdbc.Driver");
			//Class.forName("com.mysql.cj.jdbc.Driver");

			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/e_book","root","");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	public static Connection getConnection() {
		return connection;
	}
}

