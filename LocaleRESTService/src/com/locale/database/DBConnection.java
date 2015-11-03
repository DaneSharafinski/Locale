package com.locale.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DBConnection {
	private String url;
	private String usr;
	private String pwd;
	private static DBConnection instance;

	private DBConnection()
	{
    	String driver = null;
		try {
            ResourceBundle bundle = ResourceBundle.getBundle("database");
            driver = bundle.getString("jdbc.driver");
            System.out.println("got here");
            Class.forName(driver);
            System.out.println("got here");
            url=bundle.getString("jdbc.url");
            usr=bundle.getString("db_usr");
            pwd=bundle.getString("db_pwd");
            System.out.println("got here");
            
            System.out.println("url = " + url);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws SQLException {
		if (instance == null) {
			instance = new DBConnection();
		}
		try {
			return DriverManager.getConnection(instance.url);
		} catch (SQLException e) {
			throw e;
		}
	}
	
	public static void close(Connection connection)
	{
		try {
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
