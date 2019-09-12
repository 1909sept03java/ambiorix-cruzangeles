package question09;

import java.util.ArrayList;
import java.util.Iterator;

/*
 * Q9. Create an ArrayList which stores numbers from 1 to 100 and prints out all the prime numbers to the console. 
 */

public class Q09 {

	public static void main(String[] args) {
		
		ArrayList<Integer> arrList = new ArrayList<Integer>();
		for(int i = 1; i <= 100; i++) arrList.add(i);
		Iterator<Integer> arrListIterator = arrList.iterator();
		int temp = 0;
		while(arrListIterator.hasNext()) {
			temp = arrListIterator.next();
			if(isPrime(temp)) System.out.print(temp + ", ");
		}
	}
	
	static boolean isPrime(int n) {
	    //check if n is a multiple of 2
	    if (n%2==0) return false;
	    //if not, then just check the odds
	    for(int i=3;i*i<=n;i+=2) {
	        if(n%i==0)
	            return false;
	    }
	    return true;
	}
}
