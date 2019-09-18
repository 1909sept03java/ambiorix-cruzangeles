package com.revature.admin;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.revature.utility.ConnectionUtility;

public class Admin {

	// returns true if admin login is successful
	public static boolean login(String username, String password) {
		// exception handling, IOException since looking for a file
		try {
			// getting real admin credentials
			String filename = "src/main/resources/connection.properties";
			Properties prop = new Properties();
			InputStream in = new FileInputStream(filename);
			prop.load(in);
			// checking user input with real admin credentials
			if (username.equals(prop.getProperty("username")) && password.equals(prop.getProperty("password"))) {
				System.out.println("ADMIN LOGIN SUCCESSFUL-");
				return true;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("ADMIN LOGIN FAILED-");
		return false;
	}

	public static void viewUsers() {
		try {
			Connection conn = ConnectionUtility.getConnection();
			System.out.println(conn);
			String query = "SELECT * FROM TABLE_USERS";
			PreparedStatement ps = conn.prepareStatement(query);
			if (ps.execute()) {
				System.out.println("QUERY SUCESSFUL-");
				ResultSet rs = ps.getResultSet();
				String userID = null;
				String username = null;
				String password = null;
				while (rs.next()) {
					userID = rs.getString("USER_ID");
					username = rs.getString("USER_USERNAME");
					password = rs.getString("USER_PASSWORD");
					System.out.println("| "+userID+" | "+" | "+username+" | "+" | "+password+" |");
				}
			}
		} catch (SQLException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
