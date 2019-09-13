package com.revature.main;

import java.sql.Connection;

import come.revature.util.ConnectionUtil;

public class Driver {

	public static void main(String[] args) {

		try {
			String filename = "src/main/resources/connection.properties";
			Connection conn = ConnectionUtil.getConnectionFromFile(filename);
			System.out.println(conn);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
