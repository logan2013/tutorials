package com.imtzp.nio.selector;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class EchoClient {

	private static SocketChannel clientChannel;
	private static EchoClient client;
	private static ByteBuffer byteBuffer;

	public static EchoClient start() throws Exception {
		client = new EchoClient();
		return client;
	}

	private EchoClient() throws Exception {
		clientChannel = SocketChannel.open(new InetSocketAddress("localhost", 5454));
		byteBuffer = ByteBuffer.allocate(256);
	}

	public String sendMessage(String msg) throws Exception {

		byteBuffer.put(msg.getBytes());
		/**
		 * must filp first to reset the postion
		 */
		byteBuffer.flip();
		clientChannel.write(byteBuffer);
		
		byteBuffer.clear();
		clientChannel.read(byteBuffer);
		String response = new String(byteBuffer.array()).trim();
		byteBuffer.clear();
		return response;
	}
}
