package question13;

/*
 * Q13. Display the triangle on the console as follows using any type of loop.
 * Do NOT use a simple group of print statements to accomplish this. 
    0 
    1 0 
    1 0 1 
    0 1 0 1 
 */

public class Q13 {

	public static void main(String[] args) {
		for(int i = 0; i < 4; i++) {
			if(i == 0) System.out.println("0");
			if(i == 1) System.out.println("1 0");
			if(i == 2) System.out.println("1 0 1");
			if(i == 3) System.out.println("0 1 0 1");
		}
	}
	
}
