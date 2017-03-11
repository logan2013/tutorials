package com.imtzp.stream;

import org.junit.Test;

public class StreamOfStringUtilTest {

	@Test
	public void testJoin() {

		System.out.println(StreamOfStringUtil.join(new String[] { "hello", "world" }));
	}

	@Test
	public void testJoinWithPrefixPostfix() {

		System.out.println(StreamOfStringUtil.joinWithPrefixPostfix(new String[] { "hello", "world" }));
	}

	@Test
	public void testSplit() {
		System.out.println(StreamOfStringUtil.split("welcome, world, hello"));
	}
	
	@Test
	public void testSplitToListOfChar() {
		System.out.println(StreamOfStringUtil.splitToListOfChar("hello"));
	}
}
