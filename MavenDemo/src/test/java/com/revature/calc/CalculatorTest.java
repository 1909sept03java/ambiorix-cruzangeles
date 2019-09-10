package com.revature.calc;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

// fully qualified class name, saves us typing

public class CalculatorTest {

	private static Calculator calculator;
	
	/*
	 * Unit Testing: testing most granular code possible - line and branch coverage of methods
	 * 
	 * TDD (Test Driven Development): style of development in which the tests are written before the code
	 * red-green refactoring: start with the requirement, write the test, build code to match
	 * 
	 * 1. calling add("") return double of 0
	 * 2. calling add() with null returns 0
	 * 3. calling add() with !=2 comma-separated arguments throws CalculatorException
	 * 4. calling add() with incorrect characters throws CalculatorException
	 * 5. calling add() with two comma-seperated numeric values returns their sum
	 * 
	 */
	
	// if any exception is thrown, test will fail
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@BeforeClass
	public static void initializeCalculator() {
		calculator = new Calculator();
	}
	
	@Test
	public void emptyStringReturnsZero() throws CalculatorException {
		assertEquals(0, calculator.add(""), .0001);
	}
	
	@Test
	public void nullStringReturnsZero() throws CalculatorException {
		assertEquals(0, calculator.add(null), .0001);
	}
	
	@Test
	public void moreThanTwoThrowsExceptio() throws CalculatorException {
		thrown.expect(CalculatorException.class);
		calculator.add("4,5,6");
	}
	
}
