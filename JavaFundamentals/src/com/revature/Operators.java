package com.revature;

public class Operators {
	/*
	 * an operator is a special symbol that can be applied to a set of variables
	 * values, or literals, referred to as operands
	 * unary, binary, ternary operators
	 */
	
	public static void main(String[] args) {
		//----------------unary-----------------------------------------------------
		
		//----------------incrementation-sdecremetation------------------------------
		int x = 5;
		++x;
		x++;
		--x;
		x--;
		
		//----------------twos complement-------------------------------------------
		x = ~x; // -(n+1)
		
		//---------------negate, positive, and opposite-----------------------------
		x = -x;
		x = +x;
		boolean y = true;
		y = !y;
		
		//-----------------binary---------------------------------------------------
		int a = 0;
		int b = 0;
		int z = 0;
		z = a + b;
		z = a - b;
		z = a / b;
		z = a * b;
		z = a % b; // returns the remainder
		
		//-----------------ternary operators----------------------------------------
		
		System.out.println(x > 0 ? "X is greater" : "X is smaller");
		
	}
	
	
	
}
