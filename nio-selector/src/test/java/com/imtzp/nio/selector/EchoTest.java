package com.imtzp.nio.selector;

import org.junit.Assert;
import org.junit.Test;

public class EchoTest {

	@Test
	public void test() throws Exception {
		
		EchoClient client = EchoClient.start();
		String hello = client.sendMessage("hello");
		Assert.assertEquals("hello", hello);
		
		String world = client.sendMessage("world");
		Assert.assertEquals("world", world);
	}
}
