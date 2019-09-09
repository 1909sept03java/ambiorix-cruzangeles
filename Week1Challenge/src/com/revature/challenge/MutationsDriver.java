package com.revature.challenge;

public class MutationsDriver {

	public static void main(String[] args) {
		
		// hard coded example to start with, later maybe text file for bank
		String start = "AACCGGTT";
		String end = "AAACGGTA";
		String[] bank = {"AACCGGTA", "AACCGCTA", "AAACGGTA"};
		
		System.out.println(numMutations(start, end, bank));
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
		if(start.equals(end)) return 0;
		
		int mutations = 0; // the variable to return
		
		for(int i = 0; i < start.length(); i++) { // looping through the start sequence
			if(start.charAt(i) != end.charAt(i)) { // checking for any mutations
				for(String str : bank) { // looping through bank
					if(start.charAt(i) == str.charAt(i)) // checking if the mutation is valid
					mutations++; // incrementing the variable that will be returned
					continue; // once the mutation is found then break out of the loop
				}
			}
		}
		return mutations;
	}
}
