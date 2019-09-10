package com.revature.calc;

public class Calculator {

	public double add(String s) throws CalculatorException {
		Double sum = 0.0;
		if(s==null || s.equals("")) {
			return sum;
		} else {
			String[] numbers = s.split(",");
			if(numbers.length != 2) {
				throw new CalculatorException("Too many or too few values");
			}
		}
		return sum;
	}
	
}
