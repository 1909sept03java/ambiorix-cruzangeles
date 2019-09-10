package question03;

/*
 * Q3. Reverse a string without using a temporary variable.
 * Do NOT use reverse() in the StringBuffer or the StringBuilder APIs.
 */
public class Q03 {
	
	public static void main(String[] args) {
		String str = "Hello my name is rex.";
		reverse(str);
	}
	
	static void reverse(String s) {
		for(int i = s.length()-1; i >= 0; i--) {
			System.out.print(s.charAt(i));
		}
	}
}
