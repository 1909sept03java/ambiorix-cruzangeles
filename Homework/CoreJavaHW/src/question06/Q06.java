package question06;

/*
 * Q6. Write a program to determine if an integer is even without using the modulus operator (%) 
 */

public class Q06 {

	public static void main(String[] args) {
		System.out.println(isEven(20));
		System.out.println(isEven(17));
	}
	
	static boolean isEven(int num) {
		if(num%2==0) return true;
		else return false;
	}
}
