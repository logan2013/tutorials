package com.imtzp.off.heap.array;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.util.NoSuchElementException;
import java.util.PrimitiveIterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.IntConsumer;

public class OffHeapIntArray implements Iterable<Integer> {

	private final IntBuffer buffer;
	private final int length;

	public OffHeapIntArray(int length) {

		if (length <= 0) {
			throw new IllegalArgumentException();
		}

		this.length = length;
		/**
		 * Allocates memory off heap
		 */
		this.buffer = ByteBuffer.allocateDirect(length * Integer.BYTES).asIntBuffer();
	}

	public int get(int index) {
		return buffer.get(index);
	}

	public void set(int index, int value) {
		buffer.put(index, value);
	}

	public int length() {
		return length;
	}

	@Override
	public PrimitiveIterator.OfInt iterator() {
		return new Iter();
	}

	@Override
	public Spliterator<Integer> spliterator() {
		return Spliterators.spliterator(iterator(), length,
				Spliterator.SIZED | Spliterator.SUBSIZED | Spliterator.NONNULL | Spliterator.CONCURRENT);
	}

	private final class Iter implements PrimitiveIterator.OfInt {

		private int currentIndex;

		public Iter() {
			currentIndex = 0;
		}

		@Override
		public void forEachRemaining(IntConsumer action) {
			while (currentIndex < length) {
				action.accept(get(currentIndex++));
			}
		}

		@Override
		public boolean hasNext() {
			return currentIndex < length;
		}

		@Override
		public Integer next() {
			return nextInt();
		}

		@Override
		public int nextInt() {
			if (hasNext()) {
				return get(currentIndex++);
			}

			throw new NoSuchElementException();
		}
	}
}
