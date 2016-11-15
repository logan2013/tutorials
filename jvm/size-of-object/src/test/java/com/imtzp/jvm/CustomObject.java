package com.imtzp.jvm;

public class CustomObject {
	
	/**
	 * class pointer 4-> 4
	 * mark word 8-> 12
	 */
	
	
	/**
	 * 4-> 16
	 */
	private int i1 = 1;
	
	/**
	 * 4-> 20
	 */
	private int i2 = 2;
	
	/**
	 * 1-> 21
	 */
	private boolean flag = true;
	
	/**
	 * 4-> 25
	 */
	private Object o1;

	/**
	 * 4-> 29
	 */
	private int i3;
	/**
	 * 2-> 31
	 */
	private char c1;
	/**
	 * 1-> 32
	 */
	private boolean flag2;
	
	/**
	 * 当前对象 4-> 36 + 4(padding)=>40
	 * 
	 * o对象：16
	 */
	private Object o = new Object();
	
	/**
	 * 当前对象 4-> 40
	 * 
	 * o对象：16
	 */
	private int i5;
	
	/**
	 * 当前对象 4-> 44 + 4 => 48
	 * 
	 * o对象：16
	 * l1对象：24
	 */
	private long l1 = new Long(5);
}
