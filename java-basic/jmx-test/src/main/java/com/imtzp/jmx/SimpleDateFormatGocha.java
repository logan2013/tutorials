package com.imtzp.jmx;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatGocha {

	public static void main(String[] args) throws Exception {
		
		normalMode();
		
		strictMode();
	}

	/**
	 * 默认模式-不容错
	 * 
	 * @throws ParseException
	 */
	private static void normalMode() throws ParseException {
		SimpleDateFormat expiryDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		Date date = expiryDateFormat.parse("2016-26-10");
		
		System.out.println(date);
	}

	/**
	 * 严格模式
	 * @throws ParseException
	 */
	private static void strictMode() throws ParseException {
		SimpleDateFormat expiryDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		expiryDateFormat.setLenient(false);
		
		Date date = expiryDateFormat.parse("2016-26-10");
		
		System.out.println(date);
	}
}
