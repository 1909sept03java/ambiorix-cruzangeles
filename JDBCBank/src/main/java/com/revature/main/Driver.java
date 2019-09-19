package com.revature.main;

import java.util.Scanner;

import com.revature.admin.Admin;

public class Driver {

	// private static final Exception InvalidUserIDException = null;
	private static Scanner scanner = new Scanner(System.in);
	private static String input = null;
	private static String username = null;
	private static String password = null;
	private static boolean isON = true;
	private static boolean isON2 = true;

	public static void main(String[] args) {

		do {
			// beginning screen
			System.out.println("Welcome to Rex's JDBCBank Console Application!");
			System.out.println("Would you like to \n1) |CREATE| \n2) |LOGIN| \n3) |ADMIN LOGIN| \n4) |EXIT|");
			input = scanner.nextLine();

			// switching between screens
			switch (input) {

			case "1": // creating a new user
				// user interaction
				System.out.println("CREATING NEW USER-");
				System.out.println("USERNAME: ");
				username = scanner.nextLine();
				System.out.println("PASSWORD: ");
				password = scanner.nextLine();
				Admin.insertUser(username, password);
				break;

			case "2": // logging in as an existing user
				break;

			case "3": // logging in as admin
				// user interaction
				System.out.println("ADMIN LOGGING IN-");
				System.out.println("USERNAME: ");
				username = scanner.nextLine();
				System.out.println("PASSWORD: ");
				password = scanner.nextLine();

				// entering the admin screen
				if (Admin.login(username, password)) {
					do {
						System.out.println(
								"Would you like to \n1) |VIEW USERS| \n2) |INSERT NEW USER| \n3) |UPDATE EXISTING USER| \n4) |DELETE USER| \n5) |EXIT|");
						input = scanner.nextLine();

						// switching between screens
						switch (input) {

						case "1": // viewing users
							Admin.viewUsers();
							break;

						case "2": // creating a new user
							// user interaction
							System.out.println("CREATING NEW USER-");
							System.out.println("USERNAME: ");
							username = scanner.nextLine();
							System.out.println("PASSWORD: ");
							password = scanner.nextLine();
							Admin.insertUser(username, password);
							break;

						case "3": // updating a user
							// user interaction
							System.out.println("UPDATING A USER-");
							System.out.println("ENTER USER_ID TO UPDATE: ");
							input = scanner.nextLine();
							if (!(Integer.parseInt(input) >= 0 && Integer.parseInt(input) <= 1000)) {
								// throw InvalidUserIDException;
							}
							System.out.println("USERNAME: ");
							username = scanner.nextLine();
							System.out.println("PASSWORD: ");
							password = scanner.nextLine();
							Admin.updateUser(username, password, Integer.parseInt(input));
							break;
							
						case "4":
							System.out.println("DELETING A USER-");
							System.out.println("ENTER USER_ID TO DELETE: ");
							input = scanner.nextLine();
							if (!(Integer.parseInt(input) >= 0 && Integer.parseInt(input) <= 1000)) {
								// throw InvalidUserIDException;
							}
							Admin.deleteUser(Integer.parseInt(input));
							break;
							
						case "5": // exiting main admin screen
							System.out.println("EXITING ADMIN SCREEN-");
							isON2 = false;
							break;

						default:
							System.out.println("INCORRECT INPUT- TRY AGAIN");
						}
					} while (isON2);
				}
				break;

			case "4": // exiting
				System.out.println("EXITING-");
				isON = false;
				break;

			default: // incorrect input
				System.out.println("INCORRECT INPUT- TRY AGAIN");
			}
		} while (isON);

		System.out.println("Thank you for using Rex's JDBCBank Console Application!");
		scanner.close();
	}

	class InvalidUserIDException extends Exception {

		private static final long serialVersionUID = 1L;

		InvalidUserIDException() {
			super();
			// TODO Auto-generated constructor stub
		}

	}

}
