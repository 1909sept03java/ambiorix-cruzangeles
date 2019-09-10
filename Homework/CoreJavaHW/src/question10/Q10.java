package question10;

/*
 * Q10. Find the minimum of two numbers using ternary operators. 
 */
public class Q10 {

	public static void main(String[] args) {
		System.out.println(minimum(2,3));
		System.out.println(minimum(7,3));
		System.out.println(minimum(4,1));
		System.out.println(minimum(6,0));
	}
	
	static int minimum(int a, int b) {
		return a > b ? b : a;
	}
}
