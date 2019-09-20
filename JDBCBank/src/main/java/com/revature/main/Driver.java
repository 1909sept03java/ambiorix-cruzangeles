package com.revature.main;

import java.util.Scanner;

import com.revature.admin.Admin;
import com.revature.user.User;

public class Driver {

	// variables for user input
	private static Scanner scanner = new Scanner(System.in);
	private static String input = null;
	private static String username = null;
	private static String password = null;

	// variables for the do-while loops (main interface, admin interface, user interface)
	private static boolean isON = true;
	private static boolean isON2 = true;
	private static boolean isON3 = true;
	
	// userID and bankID variables
	private static int userID = -1;
	private static String bankID = null;

	public static void main(String[] args) {

		do {
			System.out.println("Welcome to Rex's JDBCBank Console Application!");
			System.out.println("Would you like to \n1) |CREATE| \n2) |LOGIN| \n3) |ADMIN LOGIN| \n4) |EXIT|");
			input = scanner.nextLine();
			switch (input) {
			case "1": // creating a new user
				if (getUsernamePassword(0)) { // the 0 is for creating
					if (User.exists(username, password))
						System.out.println("Can't create a user that already exists.");
					else
						User.create(username, password);
				}
				break;
			case "2": // logging in as an existing user
				if (getUsernamePassword(1)) { // the 1 is for logging in
					if (User.exists(username, password)) {
						do {
							userID = User.getID(username, password);
							System.out.println(
									"Would you like to \n1) |VIEW ACCOUNTS| \n2) |CREATE AN ACCOUNT| \n3) |DEPOSIT| \n4) |WITHDRAWAL| \n5) |DELETE ACCOUNT| \n6) |EXIT|");
							input = scanner.nextLine();
							switch (input) {
							case "1": // viewing accounts
								User.viewAccounts(userID);
								isON3 = true;
								break;
							case "2": // creating a new account
								System.out.println("CREATING ACCOUNT-");
								System.out.println("STARTING BALANCE:");
								input = scanner.nextLine();
								User.insertAccounts(input, userID);
								isON3 = true;
								break;
							case "3": // deposit
								System.out.println("DEPOSITING-");
								System.out.println("ENTER BANK ID TO DEPOSIT INTO:");
								bankID = scanner.nextLine();
								System.out.println("AMOUNT TO DEPOSIT:");
								input = scanner.nextLine();
								try {
									if (Double.parseDouble(input) < 0) {
										System.out.println("invalid input");
									}
									else 
										User.deposit(input, bankID);
								} catch (NumberFormatException e) {
									System.out.println("invalid input");
								}
								isON3 = true;
								break;
							case "4": // withdrawal
								System.out.println("WITHDRAWAL-");
								System.out.println("ENTER BANK ID TO WITHDRAWAL FROM:");
								bankID = scanner.nextLine();
								System.out.println("AMOUNT TO WITHDRAWAL:");
								input = scanner.nextLine();
								try {
									if (Double.parseDouble(input) < 0) {
										System.out.println("invalid input");
									}
									else 
										User.withdrawal(input, bankID);
								} catch (NumberFormatException e) {
									System.out.println("invalid input");
								}
								isON3 = true;
								break;
							case "5": // deleting an account
								System.out.println("DELETING AN ACCOUNT-");
								System.out.println("ENTER BANK ID TO DELETE:");
								bankID = scanner.nextLine();
								User.deleteAccount(bankID);
								isON3 = true;
								break;
							case "6": // exiting
								System.out.println("EXITING LOGIN SCREEN-");
								isON3 = false;
								break;
							default:
								System.out.println("INCORRECT INPUT- TRY AGAIN");
							}
						} while (isON3);
					}
					
				}
				isON = true;
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
							isON2 = true;
							break;
						case "2": // creating a new user
							// user interaction
							System.out.println("CREATING NEW USER-");
							System.out.println("USERNAME: ");
							username = scanner.nextLine();
							System.out.println("PASSWORD: ");
							password = scanner.nextLine();
							Admin.insertUser(username, password);
							isON2 = true;
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
							isON2 = true;
							break;
						case "4":
							System.out.println("DELETING A USER-");
							System.out.println("ENTER USER_ID TO DELETE: ");
							input = scanner.nextLine();
							if (!(Integer.parseInt(input) >= 0 && Integer.parseInt(input) <= 1000)) {
								// throw InvalidUserIDException;
							}
							Admin.deleteUser(Integer.parseInt(input));
							isON2 = true;
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
				isON = true;
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

	public static boolean getUsernamePassword(int num) {
		username = null;
		password = null;
		switch (num) {
		case 0:
			System.out.println("CREATING NEW USER-");
			break;
		case 1:
			System.out.println("LOGGING IN AS EXISTING USER-");
			break;
		default:
		}
		System.out.println("USERNAME:");
		username = scanner.nextLine();
		if (!(username.length() > 0 && username.length() <= 20)) {
			System.out.println("Username length must be between 1 and 20.");
			return false;
		}
		System.out.println("PASSWORD:");
		password = scanner.nextLine();
		if (!(password.length() > 0 && password.length() <= 20)) {
			System.out.println("Password length must be between 1 and 20.");
			return false;
		}
		return true;
	}

}
