package com.revature;

public class Converter {

	
	public static void main(String[] args) {
		System.out.println(convertToHex(151928));
	}
	
	static String convertToHex(int x) {
		
		/* simple case
		 * if (x < 10) return "0x"+Integer.toString(x);
		 * if (x == 10) return "0xa";
		 * if (x == 11) return "0xb";
		 * if (x == 12) return "0xc";
		 * if (x == 13) return "0xd";
	 	 * if (x == 14) return "0xe";
		 * if (x == 15) return "0xf";
		 */
		
		int intR = 0;
		String strR = "";
		while (x > 0) {
			intR = x%16;
			if (intR < 10) strR = Integer.toString(intR) + strR;
			if (intR == 10) strR = "a" + strR;
			if (intR == 11) strR = "b" + strR;
			if (intR == 12) strR = "c" + strR;
			if (intR == 13) strR = "d" + strR;
			if (intR == 14) strR = "e" + strR;
			if (intR == 15) strR = "f" + strR;
			x = x / 16; 
		}
		
		return "0x"+ strR;
	}
}
