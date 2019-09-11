package question02;

/*
 * Q2. Write a program to display the first 25 Fibonacci numbers beginning at 0.
 */

public class Q02 {

	public static void main(String[] args) {
		for(int i = 0; i <= 25; i++) {
			System.out.println(fibonacci(i));
		}
	}
	
	static int fibonacci(int num) {
		if(num == 0) {
			return 0;
		}
		else if(num == 1) {
			return 1;
		}
		else {
			int temp1 = 0;
			int temp2 = 1;
			int temp3 = 0;
			for(int i = 1; i < num; i++) {
				temp3 = temp1 + temp2;
				temp1 = temp2;
				temp2 = temp3;
			}
			return temp3;
		}
	}
}
