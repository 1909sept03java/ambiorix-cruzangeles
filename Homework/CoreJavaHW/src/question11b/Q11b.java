package question11b;

import question11a.Q11a;

/*
 * Q11. Write a program that would access two float-variables
 * from a class that exists in another package. Note, you will
 * need to create two packages to demonstrate the solution
 */
public class Q11b {

	public static void main(String[] args) {
		Q11a rex = new Q11a(1, 3);
		System.out.println(rex.a + " " + rex.b);
	}
}
