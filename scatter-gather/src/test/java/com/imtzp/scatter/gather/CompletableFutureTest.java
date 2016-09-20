package com.imtzp.scatter.gather;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CompletableFutureTest {

	private static final Logger LOG = LoggerFactory.getLogger(SequentialTest.class);

	@Test
	public void test() throws Exception {

		ExecutorService executorService = Executors.newFixedThreadPool(20);

		LOG.info("starting......");

		List<CompletableFuture<String>> futures = IntStream.range(0, 10).boxed()
				.map(i -> this.generateTask(i, executorService)).collect(Collectors.toList());

		CompletableFuture<List<String>> result = CompletableFuture
				.allOf(futures.toArray(new CompletableFuture[futures.size()]))
				.thenApply(v -> futures.stream().map(CompletableFuture::join).collect(Collectors.toList()));

		result.thenAccept(l -> LOG.info(l.toString()));

		result.get();
	}

	private CompletableFuture<String> generateTask(int i, ExecutorService executorService) {
		return CompletableFuture.supplyAsync(() -> {

			LOG.info("invoking......");

			try {
				Thread.sleep(2000);
			} catch (Exception e) {
				e.printStackTrace();
			}

			return i + "-" + "test";
		} , executorService);
	}
}
