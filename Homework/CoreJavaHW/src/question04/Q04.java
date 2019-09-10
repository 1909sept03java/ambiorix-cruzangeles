package question04;

/*
 * Q4. Write a program to compute N factorial.
 */
public class Q04 {

	public static void main(String[] args) {
		System.out.println(factorial(10));
	}
	
	static int factorial(int n) {
		int answer = 1;
		for(int i = 1; i <= n; i++) {
			answer = i*answer;
		}
		return answer;
	}
}
