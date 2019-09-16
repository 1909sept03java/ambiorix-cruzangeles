package com.revature;

import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {

		// variables for user input
		Scanner scanner = new Scanner(System.in);
		String input;
		
		do {
			System.out.println("Would you like to |CREATE| , |LOGIN| , |EXIT| ?");
			input = scanner.nextLine();
		} while(!(input.equals("CREATE") || input.equals("LOGIN") || input.equals("EXIT")));
		
		switch(input) {
		case "CREATE":
			break;
		case "LOGIN":
			break;
		case "EXIT":
			System.out.println("Exiting Console Application");
			break;
		default:
			System.out.println("Exiting Console Application");
		}
		
		scanner.close();
		
	}

}
