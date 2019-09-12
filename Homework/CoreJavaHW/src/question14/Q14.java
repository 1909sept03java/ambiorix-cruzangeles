package question14;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * Q14. Write a program that demonstrates the switch case. Implement the following functionalities in the cases: 
Case 1: Find the square root of a number using the Math class method.  
Case 2: Display today’s date. 
Case 3: Split the following string and store it in a string array.  
  “I am learning Core Java"
 */

public class Q14 {

	public static void main(String[] args) {
		int choice = 1;
		switch(choice) {
		case 0:
			System.out.println(Math.sqrt(49));
			break;
		case 1:
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();
			System.out.println(dateFormat.format(date));
			break;
		case 2:
			String s = "I am learning Core Java";
			String[] s_split = s.split(" ");
			for(String str : s_split) System.out.println(str);
		}
	}
}
