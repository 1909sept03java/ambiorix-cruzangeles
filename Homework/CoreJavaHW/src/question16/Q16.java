package question16;

/*
 * Q16. Write a program to display the number of characters for a string input.
 * The string should be entered as a command line argument using (String [ ] args). 
 */

public class Q16 {

	public static void main(String[] args) {
		// String[] args = {"Hello", "my", "name", "is", "rex"};
		int numOfChars = 0;
		for(int i =0; i < args.length; i++) {
			numOfChars += args[i].length();
		}
		System.out.println(numOfChars);
	}
}
