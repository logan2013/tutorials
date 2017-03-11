package com.imtzp.rxjava2;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import io.reactivex.Observable;

public class RxJava2Test {

	/**
	 * Observable.just方法创建一个Observable对象，发射单个event
	 */
	@Test
	public void testJust() {

		Observable<String> howdy = Observable.just("howdy");
		howdy.subscribe(System.out::println);
	}

	/**
	 * Observable.just重载方法，可以接收10个参数
	 */
	@Test
	public void testJustOverload() {

		Observable.just("hello", "world", "welcome").subscribe(System.out::println);
	}

	/**
	 * just一个List，实际上只发射了一个event
	 */
	@Test
	public void testJustInputAnArray() {

		List<String> words = Arrays.asList("the", "quick", "brown", "fox", "jumped", "over", "the", "lazy", "dog");
		Observable.just(words).subscribe(System.out::println);
	}

	@Test
	public void testFromIterable() {

		List<String> words = Arrays.asList("the", "quick", "brown", "fox", "jumped", "over", "the", "lazy", "dog");
		Observable.fromIterable(words).subscribe(System.out::println);
	}

	/**
	 * 发送number事件
	 */
	@Test
	public void testRange() {

		Observable.range(1, 5).subscribe(System.out::println);
	}

	/**
	 * zip两个Stream，任何一个Stream结束时，另外一个Stream都会结束
	 */
	@Test
	public void testZipWith() {

		List<String> words = Arrays.asList("the", "quick", "brown", "fox", "jumped", "over", "the", "lazy", "dog");

		Observable.fromIterable(words)
				.zipWith(Observable.range(1, Integer.MAX_VALUE), (str, count) -> String.format("%2d. %s", count, str))
				.subscribe(System.out::println);
	}

	/**
	 * flatMap从一个Obserable中取出events，每个event分别转换成一个Observable，
	 * 然后flattens这些Observable成单个Observable
	 */
	@Test
	public void testFlatMap() {

		List<String> words = Arrays.asList("the", "quick", "brown", "fox", "jumped", "over", "the", "lazy", "dog");

		Observable.fromIterable(words).flatMap(word -> Observable.fromArray(word.split("")))
				.zipWith(Observable.range(1, Integer.MAX_VALUE), (str, count) -> String.format("%2d. %s", count, str))
				.subscribe(System.out::println);
	}

	@Test
	public void testFlatMapAndDistinct() {

		List<String> words = Arrays.asList("the", "quick", "brown", "fox", "jumped", "over", "the", "lazy", "dog");

		Observable.fromIterable(words).flatMap(word -> Observable.fromArray(word.split(""))).distinct()
				.zipWith(Observable.range(1, Integer.MAX_VALUE), (str, count) -> String.format("%2d. %s", count, str))
				.subscribe(System.out::println);
	}

	@Test
	public void testSorted() {

		List<String> words = Arrays.asList("the", "quick", "brown", "fox", "jumped", "over", "the", "lazy", "dogs");

		Observable.fromIterable(words).flatMap(word -> Observable.fromArray(word.split(""))).distinct().sorted()
				.zipWith(Observable.range(1, Integer.MAX_VALUE), (str, count) -> String.format("%2d. %s", count, str))
				.subscribe(System.out::println);
	}
}
