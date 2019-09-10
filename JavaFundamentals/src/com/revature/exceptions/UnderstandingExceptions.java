package com.revature.exceptions;

import java.util.Scanner;

public class UnderstandingExceptions {

	static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		indexOut();
		nullPtr();
		divide(10, 0);
	}
	
	static void run() {
		System.out.println("Enter a number: ");
		try {
			String str = scanner.nextLine();
			int num = Integer.parseInt(str);
			System.out.println("you entered " + num);
		}
		catch(NumberFormatException e) {
			System.out.println("You entered an invalid value, please try again!");
			run();
		}
	}
	
	static void indexOut() {
		int[] arr = {0, 1, 2, 3};
		try {
			System.out.println(arr[4]);
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("ARRAY INDEX OUT OF BOUNDS!");
		}
	}
	
	static void nullPtr() {
		UnderstandingExceptions uE = new UnderstandingExceptions();
		uE = null;
		try {
			uE.boo();
		}
		catch (NullPointerException e) {
			System.out.println("NULL POINTER EXCEPTION!");
		}
	}
	
	void boo() {
		System.out.println("BOOO!");
	}
	
	static void divide(int a, int b) {
		try {
			System.out.println(a / b);
		}
		catch(ArithmeticException e) {
			System.out.println("ARITHMETIC ERROR, DIVISION BY ZERO?");
		}
	}
}
