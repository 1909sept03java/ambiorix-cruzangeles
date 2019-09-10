package question17;

/*
 * Q17. Write a program that calculates the simple interest on the principal,
 * rate of interest and number of years provided by the user. Enter principal,
 * rate and time through the console using the Scanner class. 
Interest = Principal* Rate* Time 
 */
import java.util.Scanner;

public class Q17 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Principal: ");
		String principal = scanner.nextLine();
		System.out.println("Rate: ");
		String rate = scanner.nextLine();
		System.out.println("Time: ");
		String time = scanner.nextLine();
		System.out.println(interest(Integer.parseInt(principal), Integer.parseInt(rate), Integer.parseInt(time)));
	}
	
	static int interest(int principal, int rate, int time) {
		return principal*rate*time;
	}
}
