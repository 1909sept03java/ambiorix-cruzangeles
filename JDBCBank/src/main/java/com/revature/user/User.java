package com.revature.user;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.revature.utility.ConnectionUtility;

public class User {

	public static boolean exists(String username, String password) {
		try {
			Connection conn = ConnectionUtility.getConnection();
			System.out.println(conn);
			String query = "SELECT * FROM TABLE_USERS";
			PreparedStatement ps = conn.prepareStatement(query);
			if (ps.execute()) {
				ResultSet rs = ps.getResultSet();
				while (rs.next()) {
					if (username.equals(rs.getString("USER_USERNAME"))
							&& password.equals(rs.getString("USER_PASSWORD"))) {
						// System.out.println("USER EXISTS-");
						return true;
					}
				}
			}
		} catch (SQLException | IOException e1) {
			e1.printStackTrace();
		}
		// System.out.println("USER DOES NOT EXISTS-");
		return false;
	}

	private static String filepath = "src/main/resources/users.txt";

	public static void create(String username, String password) {
		try {
			Connection conn = ConnectionUtility.getConnection();
			System.out.println(conn);
			CallableStatement cs = conn.prepareCall("{call TABLE_USERS_INSERT(?,?)}");
			cs.setString(1, username);
			cs.setString(2, password);
			if (cs.executeUpdate() == 1) {
				System.out.println("User created successfully.");
			} else {
				System.out.println("User was not created successfully.-");
			}
		} catch (SQLException | IOException e1) {
			e1.printStackTrace();
		}
	}

	static void writeString(String USER_NAME, String USER_PASSWORD) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(filepath, true))) {
			bw.write(USER_NAME + ":" + USER_PASSWORD + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void login() {
		String USER_NAME = null;
		String USER_PASSWORD = null;
		System.out.println("LOGGING IN-");
		Scanner scanner = new Scanner(System.in);
		System.out.print("USER_NAME: ");
		USER_NAME = scanner.nextLine();
		System.out.print("USER_PASSWORD: ");
		USER_PASSWORD = scanner.nextLine();
		// System.out.println("YOU'VE ENTER: " + USER_NAME + ", " + USER_PASSWORD);
		if (read(USER_NAME, USER_PASSWORD)) {
			System.out.println("LOGIN SUCCESSFUL");
		}
		scanner.close();
	}

	static boolean read(String USER_NAME, String USER_PASSWORD) {
		boolean userExists = false;
		try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
			String currString = null;
			String combined = USER_NAME + ":" + USER_PASSWORD;
			while ((currString = br.readLine()) != null) {
				if (combined.equals(currString)) {
					userExists = true;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return userExists;
	}

	public static boolean login(String username, String password) {
		try {
			Connection conn = ConnectionUtility.getConnection();
			System.out.println(conn);
			String query = "SELECT * FROM TABLE_USERS";
			PreparedStatement ps = conn.prepareStatement(query);
			if (ps.execute()) {
				System.out.println("QUERY SUCESSFUL-");
				ResultSet rs = ps.getResultSet();
				while (rs.next()) {
					if (username.equals(rs.getString("USER_USERNAME"))
							&& password.equals(rs.getString("USER_PASSWORD"))) {
						System.out.println("REGULAR USER LOGIN SUCCESSFUL-");
						return true;
					}
				}
			}
		} catch (SQLException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("REGULAR USER LOGIN FAILED-");
		return false;
	}

	public static int getID(String username, String password) {
		try {
			Connection conn = ConnectionUtility.getConnection();
			System.out.println(conn);
			String query = "SELECT * FROM TABLE_USERS";
			PreparedStatement ps = conn.prepareStatement(query);
			if (ps.execute()) {
				// System.out.println("QUERY SUCESSFUL-");
				ResultSet rs = ps.getResultSet();
				while (rs.next()) {
					if (username.equals(rs.getString("USER_USERNAME"))
							&& password.equals(rs.getString("USER_PASSWORD"))) {
						return rs.getInt("USER_ID");
					}
				}
			}
		} catch (SQLException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// System.out.println("REGULAR USER LOGIN FAILED-");
		return -1;

	}

	public static void viewAccounts(int userID) {
		try {
			Connection conn = ConnectionUtility.getConnection();
			// System.out.println(conn);
			String query = "SELECT * FROM TABLE_BANK_ACCOUNTS WHERE USER_ID = ?";
			int bankID = 0;
			double bankBalance = 0;
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, userID);
			if (ps.execute()) {
				System.out.println("QUERY SUCESSFUL-");
				ResultSet rs = ps.getResultSet();
				while (rs.next()) {
					bankID = rs.getInt("BANK_ACCOUNT_ID");
					bankBalance = rs.getDouble("BANK_ACCOUNT_BALANCE");
					System.out.println("| " + bankID + " | " + " | " + bankBalance + " |");
				}
			}
		} catch (SQLException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public static void insertAccounts(String balance, int userID) {
		try {
			Connection conn = ConnectionUtility.getConnection();
			String query = "INSERT INTO TABLE_BANK_ACCOUNTS(BANK_ACCOUNT_ID, BANK_ACCOUNT_BALANCE, USER_ID) VALUES(TABLE_BANK_ACCOUNTS_SEQUENCE.NEXTVAL,?,?)";
			double bankBalance = Double.parseDouble(balance);
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setDouble(1, bankBalance);
			ps.setInt(2, userID);
			if (ps.execute()) {
				System.out.println("QUERY SUCESSFUL-");
			}
		} catch (SQLException | IOException e1) {
			e1.printStackTrace();
		}
	}

	public static void deposit(String balance, String bankID) {
		try {
			Connection conn = ConnectionUtility.getConnection();
			String getBalance = "SELECT * FROM TABLE_BANK_ACCOUNTS WHERE BANK_ACCOUNT_ID = ?";
			double tableBalance = 0;
			double addBalance = Double.parseDouble(balance);
			PreparedStatement pstmnt = conn.prepareStatement(getBalance);
			pstmnt.setInt(1, Integer.parseInt(bankID));
			if (pstmnt.execute()) {
				ResultSet rs = pstmnt.getResultSet();
				while (rs.next()) {
					tableBalance = rs.getDouble("BANK_ACCOUNT_BALANCE");
				}
			}
			if (tableBalance + addBalance > 99999) {
				System.out.println("Account can't exceed $99,999");
			}
			else {
				String query = "UPDATE TABLE_BANK_ACCOUNTS SET BANK_ACCOUNT_BALANCE = ?  WHERE BANK_ACCOUNT_ID = ?";
				PreparedStatement ps = conn.prepareStatement(query);
				ps.setDouble(1, tableBalance + addBalance);
				ps.setString(2, bankID);
				if (ps.execute()) {
					System.out.println("QUERY SUCESSFUL-");
				}
			}
		} catch (SQLException | IOException e1) {
			e1.printStackTrace();
		}
	}

	public static void withdrawal(String balance, String bankID) {
		try {
			Connection conn = ConnectionUtility.getConnection();
			String getBalance = "SELECT * FROM TABLE_BANK_ACCOUNTS WHERE BANK_ACCOUNT_ID = ?";
			double tableBalance = 0;
			double addBalance = Double.parseDouble(balance);
			PreparedStatement pstmnt = conn.prepareStatement(getBalance);
			pstmnt.setInt(1, Integer.parseInt(bankID));
			if (pstmnt.execute()) {
				ResultSet rs = pstmnt.getResultSet();
				while (rs.next()) {
					tableBalance = rs.getDouble("BANK_ACCOUNT_BALANCE");
				}
			}
			if (tableBalance - addBalance < 0) {
				System.out.println("Account can't go below $0");
			}
			else {
				String query = "UPDATE TABLE_BANK_ACCOUNTS SET BANK_ACCOUNT_BALANCE = ?  WHERE BANK_ACCOUNT_ID = ?";
				PreparedStatement ps = conn.prepareStatement(query);
				ps.setDouble(1, tableBalance - addBalance);
				ps.setString(2, bankID);
				if (ps.execute()) {
					System.out.println("QUERY SUCESSFUL-");
				}
			}
		} catch (SQLException | IOException e1) {
			e1.printStackTrace();
		}
	}

	
	public static void deleteAccount(String bankID) {
		try {
			Connection conn = ConnectionUtility.getConnection();
			String getBalance = "SELECT * FROM TABLE_BANK_ACCOUNTS WHERE BANK_ACCOUNT_ID = ?";
			double tableBalance = 0;
			PreparedStatement pstmnt = conn.prepareStatement(getBalance);
			pstmnt.setInt(1, Integer.parseInt(bankID));
			if (pstmnt.execute()) {
				ResultSet rs = pstmnt.getResultSet();
				while (rs.next()) {
					tableBalance = rs.getDouble("BANK_ACCOUNT_BALANCE");
				}
			}
			if (tableBalance == 0) {
				System.out.println(conn);
				CallableStatement cs = conn.prepareCall("{call TABLE_BANK_ACCOUNTS_DELETE(?)}");
				cs.setInt(1, Integer.parseInt(bankID));
				if (cs.executeUpdate() == 1) {
					System.out.println("QUERY SUCESSFUL-");
				} else {
					System.out.println("QUERY UNSCESSFUL-");
				}
			}
			else {
				System.out.println("ACCOUNT BALANCE IS NOT 0");
			}
		} catch (SQLException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
