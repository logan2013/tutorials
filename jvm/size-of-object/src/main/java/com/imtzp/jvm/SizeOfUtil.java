package com.imtzp.jvm;

import java.util.Arrays;

public abstract class SizeOfUtil {

	public double averageBytes() {
		int runs = runs();
		double[] sizes = new double[runs];
		int retries = runs / 2;
		final Runtime runtime = Runtime.getRuntime();
		for (int i = 0; i < runs; i++) {
			Thread.yield();
			long used1 = memoryUsed(runtime);
			int number = create();
			long used2 = memoryUsed(runtime);
			double avgSize = (double) (used2 - used1) / number;
			if (avgSize < 0) {
				// GC was performed.
				i--;
				if (retries-- < 0) {
					throw new RuntimeException("The eden space is not large enough to hold all the objects.");
				}
			} else if (avgSize == 0) {
				throw new RuntimeException(
						"Object is not large enough to register, try turning off the TLAB with -XX:-UseTLAB");
			} else {
				sizes[i] = avgSize;
			}
		}
		Arrays.sort(sizes);
		return sizes[runs / 2];
	}

	protected long memoryUsed(Runtime runtime) {
		return runtime.totalMemory() - runtime.freeMemory();
	}

	protected int runs() {
		return 11;
	}

	protected abstract int create();
}
