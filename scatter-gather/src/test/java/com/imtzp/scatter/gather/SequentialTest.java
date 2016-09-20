package com.imtzp.scatter.gather;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SequentialTest {

	private static final Logger LOG = LoggerFactory.getLogger(SequentialTest.class);

	@Test
	public void test() {

		LOG.info("starting......");

		List<String> list = IntStream.range(0, 10).boxed().map(this::generateTask).collect(Collectors.toList());

		LOG.info(list.toString());
	}

	private String generateTask(int i) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
		}

		return i + "-" + "test";
	}
}
