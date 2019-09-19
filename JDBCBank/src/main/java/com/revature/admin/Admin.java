package com.revature.admin;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.CallableStatement;
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
					System.out.println("| " + userID + " | " + " | " + username + " - " + password + " |");
				}
			}
		} catch (SQLException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public static void insertUser(String username, String password) {
		if (!(username.length() > 0 && username.length() <= 20)) {
			System.out.println("Username length must be between 1 and 20");
		} else if (!(password.length() > 0 && password.length() <= 20)) {
			System.out.println("Password length must be between 1 and 20");
		} else {
			try {
				Connection conn = ConnectionUtility.getConnection();
				System.out.println(conn);
				CallableStatement cs = conn.prepareCall("{call TABLE_USERS_INSERT(?,?)}");
				cs.setString(1, username);
				cs.setString(2, password);
				if (cs.executeUpdate() == 1) {
					System.out.println("QUERY SUCESSFUL-");
				} else {
					System.out.println("QUERY UNSCESSFUL-");
				}
			} catch (SQLException | IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	public static void deleteUser(int parseInt) {
		try {
			Connection conn = ConnectionUtility.getConnection();
			System.out.println(conn);
			CallableStatement cs = conn.prepareCall("{call TABLE_USERS_DELETE(?)}");
			cs.setInt(1, parseInt);
			if (cs.executeUpdate() == 1) {
				System.out.println("QUERY SUCESSFUL-");
			} else {
				System.out.println("QUERY UNSCESSFUL-");
			}
		} catch (SQLException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public static void updateUser(String username, String password, int parseInt) {
		try {
			Connection conn = ConnectionUtility.getConnection();
			System.out.println(conn);
			String query = "UPDATE TABLE_USERS SET USER_USERNAME = ?, USER_PASSWORD = ? WHERE USER_ID = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, username);
			ps.setString(2, password);
			ps.setInt(3, parseInt);
			if (ps.executeUpdate() == 1) {
				System.out.println("QUERY SUCESSFUL-");
			} else {
				System.out.println("QUERY UNSCESSFUL-");
			}
		} catch (SQLException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
