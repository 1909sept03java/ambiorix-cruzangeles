package question08;

import java.util.ArrayList;
import java.util.Iterator;

/*
 * Q8. Write a program that stores the following strings in an ArrayList
 * and saves all the palindromes in another ArrayList. 
 * “karan”, “madam”, ”tom”, “civic”, “radar”, “sexes”, “jimmy”, “kayak”, 
 * “john”,  “refer”, “billy”, “did”
 */

public class Q08 {

	public static void main(String[] args) {
		
		String[] words = {"karan", "madam", "tom", "civic", "radar", "sexes", "jimmy", "kayak", "john", "refer", "billy", "did"};
		
		ArrayList<String> arrWords = new ArrayList<String>();
		ArrayList<String> arrWordsPalindromes = new ArrayList<String>();
		
		for(String word : words) {
			
			arrWords.add(word);
			
			String wordReversed = reverse(word);
			
			if(word.equals(wordReversed)) {
				arrWordsPalindromes.add(wordReversed);
			}
			
		}
		
		for(int i = 0; i < arrWords.size(); i++) System.out.print(arrWords.get(i) + " ");
		System.out.println();
		for(int i = 0; i < arrWordsPalindromes.size(); i++) System.out.print(arrWordsPalindromes.get(i) + " ");
		
	}
	
	static String reverse(String word) {
		StringBuilder strBuilder = new StringBuilder(word);
		String wordReversed = new String(strBuilder.reverse());
		return wordReversed;
	}

}
