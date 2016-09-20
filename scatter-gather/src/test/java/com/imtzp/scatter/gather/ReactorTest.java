package com.imtzp.scatter.gather;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

public class ReactorTest {

	private static final Logger LOG = LoggerFactory.getLogger(ReactorTest.class);

	@Test
	public void test() throws Exception {

		ExecutorService executorService = Executors.newFixedThreadPool(12);

		LOG.info("starting......");

		List<Flux<String>> fluxList = IntStream.range(0, 10).boxed().map(i -> this.generateTask(i, executorService))
				.collect(Collectors.toList());

		Mono<List<String>> merged = Flux.merge(fluxList).collect(Collectors.toList());
		merged.subscribe(l -> LOG.info(l.toString()));

		merged.block();
	}

	private Flux<String> generateTask(int i, ExecutorService executorService) {
		return Flux.<String> create(s -> {

			try {
				Thread.sleep(2000);
			} catch (Exception e) {
			}

			s.next(i + "-test");
			s.complete();
		}).subscribeOn(Schedulers.fromExecutor(executorService));
	}
}
