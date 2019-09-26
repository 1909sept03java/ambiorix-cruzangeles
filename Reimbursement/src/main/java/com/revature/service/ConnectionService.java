package com.revature.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionService {

	/*
	 * this function is responsible for returning a connection to the database in
	 * question within the connection.properties file inside the resources folder
	 */

	public static Connection getConnection() throws SQLException, IOException {
		String filename = "src/main/resources/connection.properties";
		Properties prop = new Properties();
		InputStream in = new FileInputStream(filename);
		prop.load(in);
		return DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("username"),
				prop.getProperty("password"));
	}

}
