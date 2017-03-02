package com.imtzp.javafuture;

import java.util.concurrent.RecursiveTask;

public class FactorialSquareCalculator extends RecursiveTask<Integer> {

	private static final long serialVersionUID = 1242472592322305221L;

	private final Integer n;

	public FactorialSquareCalculator(Integer n) {
		this.n = n;
	}

	@Override
	protected Integer compute() {

		if (n <= 1) {
			return n;
		}

		FactorialSquareCalculator calculator = new FactorialSquareCalculator(n - 1);

		/**
		 * 分叉
		 */
		calculator.fork();

		/**
		 * 汇合
		 */
		return n * n + calculator.join();
	}
}
