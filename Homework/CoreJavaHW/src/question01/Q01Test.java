package question01;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Q01Test {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		int[] myIntArray = new int[]{3, 2, 1};
		int[] myIntArraySorted = Q01.bubbleSort(myIntArray);
		assertArrayEquals(myIntArray, myIntArraySorted);
		/*
		 * 
		int[] myIntArraySorted = new int[]{1, 2, 3};
		int[] myIntArraySortedBubble = Q01.bubbleSort(myIntArray);
		for(int i = 0; i < myIntArray.length; i++) System.out.println(myIntArray[i] +" "+ myIntArraySortedBubble[i]);
		assertEquals(myIntArraySorted, myIntArraySortedBubble);
		 */
	}

}
