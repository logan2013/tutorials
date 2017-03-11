package com.imtzp.javafuture;

import java.util.concurrent.ForkJoinPool;

import org.junit.Assert;
import org.junit.Test;

public class FactorialSquareCalculatorUnitTest {

	/**
	 * 使用ForkJoinPool实现递归
	 * 
	 */
	@Test
	public void whenCalculatesFactorialSquare_thenReturnCorrectValue() {

		FactorialSquareCalculator calculator = new FactorialSquareCalculator(10);

		ForkJoinPool forkJoinPool = new ForkJoinPool();
		forkJoinPool.execute(calculator);

		Assert.assertEquals("The sum of the squares from 1 to 10 is 385", 385, calculator.join().intValue());
	}
}
