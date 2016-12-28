package com.imtzp.exceptions.under.hood;

public class Sample {

	public static void main(String[] args) {
		try {
			Integer.parseInt(args[0]);
		} catch (NumberFormatException e) {
			System.out.println("catch");
			e.printStackTrace();
		} finally {
			System.out.println("finally");
		}
	}
}
