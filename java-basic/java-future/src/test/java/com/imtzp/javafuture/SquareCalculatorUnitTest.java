package com.imtzp.javafuture;

import java.util.concurrent.CancellationException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

public class SquareCalculatorUnitTest {

	@Rule
	public TestName name = new TestName();

	private long start;

	private SquareCalculator squareCalculator;

	/**
	 * 单线程-result1先会完成
	 * 
	 * @throws Exception
	 */
	@Test
	public void givenExecutorIsSingleThreaded_whenTwoExecutionsAreTriggered_thenRunInSequence() throws Exception {

		squareCalculator = new SquareCalculator(Executors.newSingleThreadExecutor());

		Future<Integer> result1 = squareCalculator.calculator(4);
		Future<Integer> result2 = squareCalculator.calculator(1000);

		while (!(result1.isDone() && result2.isDone())) {

			System.out.println(String.format("Task 1 is %s and Task 2 is %s.", result1.isDone() ? "done" : "not done",
					result2.isDone() ? "done" : "not done"));

			Thread.sleep(300);
		}

		Assert.assertEquals(16, result1.get().intValue());
		Assert.assertEquals(1000000, result2.get().intValue());
	}

	/**
	 * 多线程执行，result1和result并行，运行时间减少
	 * 
	 * @throws Exception
	 */
	@Test
	public void givenExecutorIsMultiThreaded_whenTwoExecutionsAreTriggered_thenRunInParallel() throws Exception {

		squareCalculator = new SquareCalculator(Executors.newFixedThreadPool(2));

		Future<Integer> result1 = squareCalculator.calculator(4);
		Future<Integer> result2 = squareCalculator.calculator(1000);

		while (!(result1.isDone() && result2.isDone())) {

			System.out.println(String.format("Task 1 is %s and Task 2 is %s.", result1.isDone() ? "done" : "not done",
					result2.isDone() ? "done" : "not done"));

			Thread.sleep(300);
		}

		Assert.assertEquals(16, result1.get().intValue());
		Assert.assertEquals(1000000, result2.get().intValue());
	}

	/**
	 * cancel操作
	 * 
	 * 调用get会抛出CancellationException异常
	 * 
	 * @throws Exception
	 */
	@Test(expected = CancellationException.class)
	public void whenCancelFutureAndCallGet_thenThrowException() throws Exception {

		squareCalculator = new SquareCalculator(Executors.newSingleThreadExecutor());

		Future<Integer> result = squareCalculator.calculator(4);

		boolean canceled = result.cancel(true);

		Assert.assertTrue("Future was canceled", canceled);
		Assert.assertTrue("Future was canceled", result.isCancelled());

		result.get();
	}

	@Before
	public void start() {
		start = System.currentTimeMillis();
	}

	@After
	public void end() {
		System.out.println(
				String.format("Test %s took %s ms \n", name.getMethodName(), System.currentTimeMillis() - start));
	}
}
