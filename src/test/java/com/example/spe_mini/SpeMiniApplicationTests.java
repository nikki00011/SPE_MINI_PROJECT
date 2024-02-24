package com.example.spe_mini;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SpeMiniApplicationTests {



	@Test
	public void testPerformPower() {
		double result = SpeMiniApplication.performPower(2, 3);
		assertEquals(8, result, 0.0001, "Testing power function");
	}



	@Test
	public void testPerformSquareRoot() {
		double result = SpeMiniApplication.performSquareRoot(25);
		assertEquals(5, result, 0.0001, "Testing square root function");
	}

	@Test
	public void testPerformFactorial() {
		double result = SpeMiniApplication.performFactorial(5);
		assertEquals(120, result, "Testing factorial function");
	}

	@Test
	public void testPerformFactorialZero() {
		double result = SpeMiniApplication.performFactorial(0);
		assertEquals(1, result, "Testing factorial of 0");
	}

	@Test
	public void testPerformFactorialOne() {
		double result = SpeMiniApplication.performFactorial(1);
		assertEquals(1, result, "Testing factorial of 1");
	}
}
