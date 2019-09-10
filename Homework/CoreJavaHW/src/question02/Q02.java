package question02;

/*
 * Q2. Write a program to display the first 25 Fibonacci numbers beginning at 0.
 */
public class Q02 {

	public static void main(String[] args) {
		fibonacci(25);
	}
	
	static void fibonacci(int num) {
		int temp1 = 0;
		int temp2 = 1;
		int temp3 = 0;
		for(int i = 0; i < num; i++) {
			temp3 = temp1 + temp2;
			temp1 = temp2;
			temp2 = temp3;
			System.out.println(temp3);
		}
	}
}
