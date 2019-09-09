package com.revature.challenge;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MutationsDriver {

	public static void main(String[] args) {
		
		// hard coded example to start with, later maybe text file for bank
		String start = "AACCGGTT";
		String end = "AAACGGTA";
		//String[] bank = {"AACCGGTA", "AACCGCTA", "AAACGGTA"};
		String filepath = "src/com/revature/challenge/bank.txt";
		String[] bank = read(filepath);
		System.out.println("Minimum number of mutations needed: " + numMutations(start, end, bank));
	}
	
	static int numMutations(String start, String end, String[] bank) {
		/*
		 * my idea behind this approach is to:
		 * first: if the start sequence is the same as the end sequence, return 0
		 * else loop through the start sequence and check it with the end sequence
		 * character by character, if there is a character difference then we have
		 * a mutation. if there is a mutation, loop through the bank and check to
		 * see if it is a valid mutation. if it is valid, increment the mutation
		 * variable by one. at the end of all this return that variable
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
			char[] tempArr = start.toCharArray(); // creating a char array of start
			if(start.charAt(i) != end.charAt(i)) { // checking for any mutations
				tempArr[i] = end.charAt(i); // making the change to char array
				String tempStr = new String(tempArr); // turning it into a String
				System.out.println(tempStr);
				for(String str : bank) { // looping through bank
					if(tempStr == str) {
						mutations++;
					}
				}
			}
		}
		return mutations;
	}
	
	static String[] read(String filepath) {
		/*
		 * function that opens a .txt file and extracts the contents
		 * of it line by line, putting it into a String array
		 * returns that string array
		 */
		try(BufferedReader br = new BufferedReader(new FileReader(filepath))) {
			String currString = null;
			ArrayList<String> bank = new ArrayList<String>();
			while((currString = br.readLine()) != null) {
				bank.add(currString);
			}
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
		String[] arrStr = new String[0];
		return arrStr;
	}
		
}
