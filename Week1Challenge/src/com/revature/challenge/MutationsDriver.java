package com.revature.challenge;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MutationsDriver {

	public static void main(String[] args) {
		
		// hard coded example to start with
		String start = "AACCGGTT";
		String end = "AAACGGTA";
		String[] bank = {"AACCGGTA", "AACCGCTA", "AAACGGTA"};
		
		// false = prints "Start string:" true = prints "End string:"
		start = getInput(false);
		end = getInput(true);
		
		// reading in the String[] bank from a file
		String filepath = "src/com/revature/challenge/bank.txt";
		bank = read(filepath);
		
		// printing the minimum number of mutations
		System.out.println("Minimum number of mutations needed: " + numMutations3(start, end, bank));
		
	}
	
	static String getInput(boolean b) {
		
		// using a scanner to get user input start and end;
		Scanner scanner = new Scanner(System.in);
		if(b) System.out.println("Start string:");
		else System.out.println("End string:");
		String temp = scanner.nextLine();
		
		// checking if input is valid
		for(int i = 0; i < temp.length(); i++) {
			if(!(temp.length()== 8) && !((temp.charAt(i) == 'A') || (temp.charAt(i) == 'C') || (temp.charAt(i) == 'G') || (temp.charAt(i) == 'T'))) {
				System.out.println("Invalid- length must be 8 and contain only ACGT");
				getInput(b);
			}
		}
		
		//closing scanner and returning
		scanner.close();
		return temp;
		
	}
	
	static String[] read(String filepath) {
		
		/*
		 * uses given filepath to parse a .txt file and return a
		 * String[] containing every line within the .txt file as a string
		 * note: uses ArrayList of strings to dynamically add each new line
		 */
		
		// AUTO-CLOSABLE
		try(BufferedReader br = new BufferedReader(new FileReader(filepath))) {
			
			// reading a line from the file and adding it to the ArrayList
			String currString = null;
			ArrayList<String> bank = new ArrayList<String>();
			while((currString = br.readLine()) != null) {
				bank.add(currString);
			}
			
			// copying the contents of an ArrayList to a String[] and returning it
			String[] arrStr = new String[bank.size()];
			for(int i = 0; i < bank.size(); i++) {
				arrStr[i] = bank.get(i);
			}
			return arrStr;
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// if the code in try-catch doesn't work return the default bank
		String[] bank = {"AACCGGTA", "AACCGCTA", "AAACGGTA"};
		return bank;
		
	}
	
	static int numMutations(String start, String end, String[] bank) {
		
		/*
		 * my idea behind this approach is to-
		 * 1) if the start sequence is the same as the end sequence, return 0
		 * 2) if the end sequence is not in the bank, return -1
		 * 3) checking number of mutations by looping through start and end,
		 * incrementing the mutations variable every time a character in the
		 * sequence is different.
		 */
		
		// checking if start sequence is the same as end sequence
		if(start.equals(end)) return 0;
		
		// checking if the end sequence exists in the bank
		boolean exists = false;
		for(String str : bank) {
			if(end.equals(str)) {
				exists = true;
			}
		}
		if (!exists) return -1;
		
		// checking number of mutations
		int mutations = 0; // the variable to return
		for(int i = 0; i < start.length(); i++) { // looping through the start sequence
			if(start.charAt(i) != end.charAt(i)) { // checking for any mutations
				mutations++; // increment mutations
			}
		}
		return mutations;
		
	}
	
	static int numMutations2(String start, String end, String[] bank) {
		
		/*
		 * my idea behind this approach is to-
		 * 1) if the start sequence is the same as the end sequence, return 0
		 * 2) if the end sequence is not in the bank, return -1
		 * 3) checking number of mutations by starting on a path, left to right
		 */
		
		// checking if start sequence is the same as end sequence
		if(start.equals(end)) return 0;
		
		// checking if the end sequence exists in the bank
		boolean exists = false;
		for(String str : bank) {
			if(end.equals(str)) {
				exists = true;
			}
		}
		if (!exists) return -1;
		
		// checking number of mutations by creating a mutation path from left to right
		int mutations = 0;
		char[] tempArr = start.toCharArray(); // creating a char array of start
		for(int i = 0; i < start.length(); i++) {
			if(start.charAt(i) != end.charAt(i)) { // checking for any mutations
				tempArr[i] = end.charAt(i);
				String tempStr = new String(tempArr); // turning it into a String
				System.out.println(tempStr);
				for(String str : bank) { // looping through bank
					if(tempStr.equals(str)) {
						mutations++;
					}
				}
			}
		}
		return mutations;
	}
	
	static int numMutations3(String start, String end, String[] bank) {
		/*
		 * checks 2 starting paths, from left to right
		 * and from right to left
		 */
		
		// checking input lengths
		if(start.length() != 8 || end.length() != 8) return -2;
		
		// checking if start sequence is the same as end sequence
		if(start.equals(end)) return 0;
				
		// checking if the end sequence exists in the bank
		boolean exists = false;
		for(String str : bank) {
			if(end.equals(str)) {
				exists = true;
			}
		}
		if (!exists) return -1;
		
		/*
		 * starting the mutations from left to right
		 * one path at a time
		 */
		int mutations1 = 0;
		char[] currStringArr = start.toCharArray();
		String currString = new String(currStringArr);
		for(int i = 0; i < start.length(); i++) {
			if(currStringArr[i] != end.charAt(i)) {
				currStringArr[i] = end.charAt(i);
				currString = new String(currStringArr);
				for(String bankStr: bank) {
					if(currString.equals(bankStr)) {
						mutations1++;
						break;
					}
				}
			}
		}
		
		/* 
		 * starting mutations from right to left
		 * one path at a time
		 */
		int mutations2 = 0;
		currStringArr = start.toCharArray();
		for(int i = start.length()-1; i >= 0; i--) {
			if(currStringArr[i] != end.charAt(i)) {
				currStringArr[i] = end.charAt(i);
				currString = new String(currStringArr);
				for(String bankStr: bank) {
					if(currString.equals(bankStr)) {
						mutations2++;
						break;
					}
				}
			}
		}
		
		/*
		 * checking to see which path finally made it to the end
		 */
		if(mutations1 - mutations2 <= 0) {
			return mutations2;
		}
		return mutations1;
	}
		
}
