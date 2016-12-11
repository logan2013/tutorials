package com.imtzp.jvm;

import java.util.AbstractMap;
import java.util.BitSet;
import java.util.Calendar;
import java.util.concurrent.atomic.AtomicReference;

import org.junit.Test;

public class SizeOfUtilTest {

	@Test
	public void testMemoryUsage() {
		
		System.out.printf("The average size of an array is %.1f bytes%n", new SizeOfUtil() {
			boolean[] obj = null;
			
			@Override
			protected int create() {

				/**
				 * 8 + (12 + 4(length))
				 */
				obj = new boolean[8];
				
				return 1;
			}
		}.averageBytes());
		
		/**
		 * TODO 数组也要占空间
		 */
		System.out.printf("The average size of an int is %.1f bytes%n", new SizeOfUtil() {
			int[] obj = null;

			@Override
			protected int create() {
				obj = new int[1024];
				return obj.length;
			}
		}.averageBytes());
		
		System.out.printf("The average size of an Object is %.1f bytes%n", new SizeOfUtil() {
			Object obj = null;

			@Override
			protected int create() {
				obj = new Object();
				return 1;
			}
		}.averageBytes());
		
		System.out.printf("The average size of an Integer is %.1f bytes%n", new SizeOfUtil() {
			Integer obj = null;

			@Override
			protected int create() {
				obj = new Integer(1);
				return 1;
			}
		}.averageBytes());
		
		System.out.printf("The average size of a Long is %.1f bytes%n", new SizeOfUtil() {
			Long obj = null;

			@Override
			protected int create() {
				obj = new Long(1);
				return 1;
			}
		}.averageBytes());
		
		System.out.printf("The average size of an AtomicReference is %.1f bytes%n", new SizeOfUtil() {
			AtomicReference obj = null;

			@Override
			protected int create() {
				obj = new AtomicReference();
				return 1;
			}
		}.averageBytes());
		
		System.out.printf("The average size of an SimpleEntry(Map.Entry) is %.1f bytes%n", new SizeOfUtil() {
			AbstractMap.SimpleEntry obj = null;

			@Override
			protected int create() {
				obj = new AbstractMap.SimpleEntry(null, null);
				return 1;
			}
		}.averageBytes());
		
		System.out.printf("The average size of a Calendar is %.1f bytes%n", new SizeOfUtil() {
			Calendar obj = null;

			@Override
			protected int create() {
				obj = Calendar.getInstance();
				return 1;
			}
		}.averageBytes());
		
		System.out.printf("The average size of an Exception is %.1f bytes%n", new SizeOfUtil() {
			Exception obj = null;

			@Override
			protected int create() {
				obj = new Exception("" + System.currentTimeMillis());
				return 1;
			}
		}.averageBytes());
		
		System.out.printf("The average size of a bit in a BitSet is %.3f bytes%n", new SizeOfUtil() {
			BitSet obj = null;

			@Override
			protected int create() {
				obj = new BitSet(128 * 1024);
				return obj.size();
			}
		}.averageBytes());

		System.out.printf("The average size of a bit in a CustomObject is %.3f bytes%n", new SizeOfUtil() {
			CustomObject obj = null;
			
			@Override
			protected int create() {
				obj = new CustomObject();
				return 1;
			}
		}.averageBytes());

	}
}
