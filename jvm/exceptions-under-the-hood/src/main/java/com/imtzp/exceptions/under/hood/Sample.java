package com.imtzp.exceptions.under.hood;

public class Sample {

	public static void main(String[] args) throws Exception {
		try {
			throw new Exception();
		} catch (Exception e) {
			System.out.print("Caught!");
		} finally {
			System.out.print("Finally!");
		}
	}
}