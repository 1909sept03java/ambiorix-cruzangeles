package com.revature.main;

import java.util.Scanner;

import com.revature.user.User;

public class Driver {

	public static void main(String[] args) {

		System.out.println("Would you like to |CREATE| , |LOGIN| , or |EXIT| ?");
		Scanner scanner = new Scanner(System.in);
		String input = null;
		input = scanner.nextLine();
		switch(input) {
		case "CREATE":
			User.create();
			break;
		case "LOGIN":
			User.login();
			break;
		case "EXIT":
			System.out.println("EXITING-");
		}
		scanner.close();
	}

}
