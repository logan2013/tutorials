package com.imtzp.rxjava2;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;

public class TickTockTest {

	/**
	 * 当前日期是否为周末
	 * 
	 * @return
	 */
	private static boolean isSlowTickTime() {

		return LocalDate.now().getDayOfWeek() == DayOfWeek.SATURDAY
				|| LocalDate.now().getDayOfWeek() == DayOfWeek.SUNDAY;
	}

	/**
	 * mock，因为不可能等到周末来测试
	 */
	private static long start = System.currentTimeMillis();

	private static boolean isSlowTickTimeStub() {
		return (System.currentTimeMillis() - start) % 30_000 >= 15_000;
	}

	public static void main(String[] args) throws Exception {

		/**
		 * 每隔一秒钟发送一个event
		 */
		Observable<Long> fast = Observable.interval(1, TimeUnit.SECONDS);

		/**
		 * 每隔三秒钟发送一个event
		 */
		Observable<Long> slow = Observable.interval(3, TimeUnit.SECONDS);

		/**
		 * 过滤，
		 * 
		 * slow只在周末发送event fast只在非周末发送event
		 */
		Observable<Long> clock = Observable.merge(slow.filter(tick -> isSlowTickTimeStub()),
				fast.filter(tick -> !isSlowTickTimeStub()));

		clock.subscribe(tick -> System.out.println(new Date()));

		Thread.sleep(60_000);
	}
}
