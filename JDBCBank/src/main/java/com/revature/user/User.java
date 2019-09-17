package com.revature.user;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class User {

	private static String filepath = "src/main/resources/users.txt";
	
	public static void create() {
		String USER_NAME;
		String USER_PASSWORD;
		System.out.println("CREATING NEW USER-");
		Scanner scanner = new Scanner(System.in);
		System.out.print("USER_NAME: ");
		USER_NAME = scanner.nextLine();
		System.out.print("USER_PASSWORD: ");
		USER_PASSWORD = scanner.nextLine();
		// System.out.println("YOU'VE ENTER: " + USER_NAME + ", " + USER_PASSWORD);
		writeString(USER_NAME, USER_PASSWORD);
		scanner.close();
	}
	
	static void writeString(String USER_NAME, String USER_PASSWORD) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(filepath, true))) {
			bw.write(USER_NAME+":"+USER_PASSWORD+"\n");
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
		if(read(USER_NAME, USER_PASSWORD)) {
			System.out.println("LOGIN SUCCESSFUL");
		}
		scanner.close();
	}
	
	static boolean read(String USER_NAME, String USER_PASSWORD) {
		boolean userExists = false;
		try(BufferedReader br = new BufferedReader(new FileReader(filepath))) {
			String currString = null;
			String combined = USER_NAME + ":" + USER_PASSWORD;
			while((currString = br.readLine())!=null) {
				if(combined.equals(currString)) {
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

}
