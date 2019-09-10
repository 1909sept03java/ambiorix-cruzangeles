package com.revature;

public class Primitives {
	
	int a; // 4 bytes = 32 bits
	boolean bo; // t or f
	char c; // 2 bytes = 16 bits, single character values held in ' '
	double d; // 8 bytes = 64 bits, decimal values
	long l; // 8 bytes = 64, whole number values with L
	float f; // 4 bytes = 32 bits, a double but smaller, more precise, needs an F
	short s; // 2 bytes = 16 bits, whole number
	byte by; // 1 byte = 8 bits
	
	// These are all implicitly imported because of java.lang
	Integer intWrap = new Integer(10);
	Boolean booWrap = new Boolean(false);
	Character chaWrap = new Character('c');
	
	static void numberBases() {
		int dec = 10; // decimal
		System.out.println(dec);
		int bin = 0b10111110; // binary (base 2; 0-1; 0b or 0B before number)
		System.out.println(bin);
		int oct = 010; // octal (base 8; 0-7; preface digits with 0)
		System.out.println(oct);
		int hex = 0xa314f; // hexadecimal (base 16, 0-9 and a-f)
		System.out.println(hex);
	}
	
	static void numberFormatting() {
		int largeNum = 1_000_000; // no underscore at the start, purely visual
		// int wrong = _1029101;
		double rightDouble = 102.302_302_290;
		// double wrongDouble = 1310_.3192;
		long max = 920149123012941052L;
	}
	
	static void casting() {
		// making a variable behave as another variable type
		int x = 32768; // overflow
		long lon = x; // implicitly casting to longer type
		short sh = (short) x; // explicitly cast to smaller type
		System.out.println(sh);
	}
	
	static char numToChar(int num) { return (char) num; }
	static int charToNum(char c) { return c; }
	
	public static void main(String[] args) {
		numberBases();
		casting();
		System.out.println(numToChar(90));
		System.out.println(charToNum('x'));
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.parseInt("5125920"));
	}
}
