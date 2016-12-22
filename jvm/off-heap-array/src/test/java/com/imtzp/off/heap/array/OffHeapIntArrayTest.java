package com.imtzp.off.heap.array;

import java.util.stream.StreamSupport;

import org.junit.Test;

public class OffHeapIntArrayTest {

	@Test
	public void test() {

		final OffHeapIntArray array = new OffHeapIntArray(10);
		array.set(0, 100);
		array.set(1, 101);
		array.set(9, 109);

		System.out.println("** Iterate **");
		for (int val : array) {
			System.out.println(val);
		}

		System.out.println("** Stream **");
		StreamSupport.stream(array.spliterator(), false).filter(i -> i > 0).forEach(System.out::println);
	}
}
