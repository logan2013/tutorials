package com.imtzp.threadpool;

import org.junit.Test;

public class ThreadPoolTest {

	@Test
	public void test1() {

		ThreadPool pool = new ThreadPool(7);

		for (int i = 0; i < 5; i++) {
			Task task = new Task(i);
			pool.execute(task);
		}
	}
}
