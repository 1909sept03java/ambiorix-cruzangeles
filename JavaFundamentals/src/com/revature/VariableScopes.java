package com.revature;

public class VariableScopes {
	
	static String myName;
	
	public static void main(String[] args) {
		myName = "REX";
		System.out.println(myName);
		
		for (int i = 0; i < 10; i++) { // block scope
			System.out.println(myName);
		}
		
	}
	
	public static void test() {
		//System.out.println(myName);
	}
}
