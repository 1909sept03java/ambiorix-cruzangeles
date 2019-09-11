package question03;

/*
 * Q3. Reverse a string without using a temporary variable.
 * Do NOT use reverse() in the StringBuffer or the StringBuilder APIs.
 */
public class Q03 {
	
	public static void main(String[] args) {
		String str = "Hello my name is rex.";
		System.out.println(reverse(str));
	}
	
	static String reverse(String s) {
		char[] charArr = s.toCharArray();
		int j = charArr.length-1;
		for(int i = 0; i < charArr.length/2; i++) {
			char temp = charArr[i];
			charArr[i] = charArr[j];
			charArr[j] = temp;
			j--;
		}
		return new String(charArr);
	}
}
