package com.revature.challenges;

import java.util.Scanner;

public class FizzBuzz {

	/* 
	 * write a program that loops from 1 to 100
	 * print every number you loop through
	 * print fizz for every third number
	 * print buzz for every fifth number
	 */
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a number for FizzBuzz: ");
		String numString = scanner.nextLine();
		scanner.close();
		int num = Integer.parseInt(numString);
		fizzBuzz(num);
	}
	
	static void fizzBuzz(int num) {
		for(int i = 1; i <= num; i++) {
			if (i%3==0 && i%5==0) System.out.println("Fizz Buzz, ");
			else if (i%3==0) System.out.println("Fizz, ");
			else if (i%5==0) System.out.println("Buzz, ");
			else System.out.println(i);
		}
	}
	
}
