package com.revature.main;

import java.util.Scanner;

import com.revature.user.User;

public class Driver {

	private static Scanner scanner = new Scanner(System.in);
	private static String input = null;
	private static boolean isON = true;

	public static void main(String[] args) {

		do {
			System.out.println("Welcome to Rex's JDBCBank Console Application!");
			System.out.println("Would you like to |CREATE| , |LOGIN| , |ADMIN LOGIN| or |EXIT| ?");
			input = scanner.nextLine();
			switch (input) {
			case "CREATE":
				User.create();
				break;
			case "LOGIN":
				User.login();
				break;
			case "EXIT":
				System.out.println("EXITING-");
				break;
			}
		} while (isON);
		scanner.close();
	}

}
