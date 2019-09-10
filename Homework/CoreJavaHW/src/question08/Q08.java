package question08;

import java.util.ArrayList;
import java.util.Iterator;

/*
 * Q8. Write a program that stores the following strings in an ArrayList
 * and saves all the palindromes in another ArrayList. 
 * “karan”, “madam”, ”tom”, “civic”, “radar”, “sexes”, “jimmy”, “kayak”, “john”,  “refer”, “billy”, “did”
 */

public class Q08 {

	public static void main(String[] args) {
		String[] str = {"karan", "madam", "tom", "civic", "radar", "sexes", "jimmy", "kayak", "john", "refer", "billy", "did"};
		ArrayList<String> arrList = new ArrayList<String>();
		for(String s : str) {
			arrList.add(s);
		}
		Iterator<String> arrListIterator = arrList.iterator();
		while(arrListIterator.hasNext()) {
			System.out.print(arrListIterator.next() + " ");
		}
		System.out.println();
		ArrayList<String> arrList2 = new ArrayList<String>();
		arrList2 = palindrome(arrList);
		Iterator<String> arrListIterator2 = arrList2.iterator();
		while(arrListIterator2.hasNext()) {
			System.out.print(arrListIterator2.next() + " ");
		}
	}

	static ArrayList<String> palindrome(ArrayList<String> arrList) {
		Iterator<String> arrListIterator = arrList.iterator();
		ArrayList<String> arrListTemp = new ArrayList<String>();
		String s = "";
		while(arrListIterator.hasNext()) {
			s = arrListIterator.next().toString();
			if(s.equals(reverse(s))) {
				arrListTemp.add(s);
			}
		}
		return arrListTemp;
	}
	
	static String reverse(String s) {
		String temp = "";
		for(int i = s.length()-1; i >= 0; i--) {
			temp = temp + s.charAt(i);
		}
		return temp;
	}
}
