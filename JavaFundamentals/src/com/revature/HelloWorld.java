/*
 * the package is always the FIRST line of a Java class
 * 
 * Java is a package-centric language - every class should be in an 
 * appropriatly named package.
 * This is how we keep our code organized
 * 
 * com.revature.intro.sub is NOT considered to be a "subpackage" of
 * com.revature.intro when we do things like import with a *, it is 
 * its own package
 */
package com.revature;

import java.util.Arrays;

// HERE is where we list all of our imports, but what is an import?

public class HelloWorld {

	public static void main(String[] args) {
		/*
		 *  in order to use an instance field inside of a static method
		 *  we must instantiate the class
		 */
		HelloWorld basics = new HelloWorld();
		basics.learnJava();
	}
	
	// CTRL + SHIFT + O : auto imports the packages
	public static void sortNums(int... nums) {
		Arrays.sort(nums);
	}
	
	void doThings() {
		learnJava();
	}
	
	void learnJava() {
		
	}
	
}

class AnotherClass {
	
	
}

