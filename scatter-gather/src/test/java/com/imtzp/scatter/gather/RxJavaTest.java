package com.imtzp.scatter.gather;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import rx.Observable;
import rx.schedulers.Schedulers;

public class RxJavaTest {

	private static final Logger LOG = LoggerFactory.getLogger(RxJavaTest.class);

	@Test
	public void test() throws Exception {

		ExecutorService executorService = Executors.newFixedThreadPool(12);

		LOG.info("starting......");

		List<Observable<String>> obs = IntStream.range(0, 10).boxed().map(i -> this.generateTask(i, executorService))
				.collect(Collectors.toList());

		Observable<List<String>> merged = Observable.merge(obs).toList();
		merged.subscribe(l -> LOG.info(l.toString()));
		
		merged.toBlocking().first();
	}

	private Observable<String> generateTask(int i, ExecutorService executorService) {
		return Observable.<String> create(s -> {

			try {
				Thread.sleep(2000);
			} catch (Exception e) {
			}

			s.onNext(i + "-test");
			s.onCompleted();
		}).subscribeOn(Schedulers.from(executorService));
	}
}
