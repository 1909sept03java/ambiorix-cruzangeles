package com.revature.challenges;

import java.util.Arrays;
import java.util.Scanner;

public class Anagram {

	/*
	 * write a method that takes in two strings
	 * and returns a boolean - true if they are 
	 * anagrams, false if they are not
	 * 
	 * ie cat, tac TRUE
	 * ie boat, tom FALSE
	 * including spaces as well. like sentences
	 * must be split into words
	 */
	public static void main(String[] args) {
		//String str1 = "hello world";
		//String str2 = "olehl drowl";
		//String str3 = "blah b blah";
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter your first string: ");
		String str1Input = scanner.nextLine();
		System.out.print("Nice! Enter your second string: ");
		String str2Input = scanner.nextLine();
		scanner.close();
		String[] str1 = str1Input.split("\\s");
		String[] str2 = str2Input.split("\\s");
		System.out.println(str1 + " is an angram of " + str2 + ": " + anagram(str1, str2));
		
	}
	
	public static boolean anagram(String[] str1, String[] str2) {
		if(str1.length != str2.length) 
			return false;
		int arr1[];
		int arr2[];
		arr1 = new int[256];
		arr2 = new int[256];
		for(String s: str1) {
			for(int i = 0; i < s.length(); i++) {
				arr1[s.charAt(i)]++;
			}
		}
		for(String s: str2) {
			for(int i = 0; i < s.length(); i++) {
				arr2[s.charAt(i)]++;
			}
		}
		if (Arrays.equals(arr1, arr2)) return true;
		else return false;
	}
	
}
