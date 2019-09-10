package com.revature.junit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MethodsTest {

	Methods m;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("This method runs before test class");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("This method runs after test class");
	}

	@Before
	public void setUp() throws Exception {
		m = new Methods();
	}

	@After
	public void tearDown() throws Exception {
		m = null;
	}

	@Test
	public void testAdd() {
		int expected = 15;
		int actual = m.add(1, 2, 3, 4, 5);
		assertEquals(expected, actual);
		assertEquals(10, m.add(5,5));
		assertNotEquals(m.add(-1, 1), 2);
	}

	@Test
	public void testAnagram() {
		fail("Not yet implemented");
	}

}
