package com.imtzp.rxjava;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import rx.Observable;

public class ObservableTest {

	/**
	 * just like the proverbial tree that falls in a forest, if nobody is around
	 * to hear it, it does not make a sound.
	 * 就像谚语所说的，一棵树在森林中倒了，如果周围没有人听到，那它根本没发出声音
	 */
	@Test
	public void test() {

		Observable<String> hello = Observable.just("Howdy!");
	}

	@Test
	public void test2() {
		Observable<String> hello = Observable.just("Hello", "World");
		hello.subscribe(System.out::println);
	}

	@Test
	public void test3() {
		List<String> words = Arrays.asList("the", "quick", "brown", "fox", "jumped", "over", "the", "lazy", "dog");

		Observable.just(words).subscribe(ws -> {
			System.out.println(ws instanceof List);

			System.out.println(ws);
		});

		Observable.from(words).subscribe(System.out::println);
	}

	@Test
	public void testZip() {
		List<String> words = Arrays.asList("the", "quick", "brown", "fox", "jumped", "over", "the", "lazy", "dog");

		Observable.from(words)
				.zipWith(Observable.range(1, Integer.MAX_VALUE), (str, count) -> String.format("%2d. %s", count, str))
				.subscribe(System.out::println);
	}

	@Test
	public void testFlatMap() {
		List<String> words = Arrays.asList("the", "quick", "brown", "fox", "jumped", "over", "the", "lazy", "dog");

		Observable.from(words).flatMap(word -> Observable.from(word.split("")))
				.zipWith(Observable.range(1, Integer.MAX_VALUE), (w, count) -> String.format("%2d. %s", count, w))
				.subscribe(System.out::println);
	}

	@Test
	public void testDistinct() {
		List<String> words = Arrays.asList("the", "quick", "brown", "fox", "jumped", "over", "the", "lazy", "dog");

		Observable.from(words).flatMap(word -> Observable.from(word.split(""))).distinct()
				.zipWith(Observable.range(1, Integer.MAX_VALUE), (w, count) -> String.format("%2d. %s", count, w))
				.subscribe(System.out::println);
	}

	@Test
	public void testSort() {
		List<String> words = Arrays.asList("the", "quick", "brown", "fox", "jumped", "over", "the", "lazy", "dog");

		Observable.from(words).flatMap(word -> Observable.from(word.split(""))).distinct().sorted()
				.zipWith(Observable.range(1, Integer.MAX_VALUE), (w, count) -> String.format("%2d. %s", count, w))
				.subscribe(System.out::println);
	}
}