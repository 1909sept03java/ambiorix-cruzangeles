package question12;

/*
 * Q12. Write a program to store numbers from 1 to 100 in an array.
 * Print out all the even numbers from the array. Use the enhanced
 * FOR loop for printing out the numbers.
 */

public class Q12 {

	public static void main(String[] args) {
		
		int[] arr = new int[100];
		for(int i = 0; i < arr.length; i++) {
			arr[i] = i+1;
		}
		for(int i : arr) {
			if(i%2==0) System.out.println(i);
		}
		
	}
}
