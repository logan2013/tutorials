package com.imtzp.rxjava;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import rx.Observable;

public class TickTock {

	private static long start = System.currentTimeMillis();

	public static void main(String[] args) throws Exception {

		Observable<Long> fast = Observable.interval(1, TimeUnit.SECONDS);
		Observable<Long> slow = Observable.interval(3, TimeUnit.SECONDS);

		Observable<Long> clock = Observable.merge(slow.filter(tick -> isSlowTime()),
				fast.filter(tick -> !isSlowTime()));

		clock.subscribe(ticket -> System.out.println(new Date()));

		Thread.sleep(60_000);
	}

	public static boolean isSlowTime() {
		return (System.currentTimeMillis() - start) % 30_000 >= 15_000;
	}
}
