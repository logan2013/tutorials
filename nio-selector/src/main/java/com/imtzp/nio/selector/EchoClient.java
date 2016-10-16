package com.imtzp.nio.selector;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class EchoClient {

	private static SocketChannel clientChannel;
	private static EchoClient client;

	public static EchoClient start() throws Exception {
		client = new EchoClient();
		return client;
	}

	private EchoClient() throws Exception {
		clientChannel = SocketChannel.open(new InetSocketAddress("localhost", 5454));
	}

	public String sendMessage(String msg) throws Exception {

		// TODO ??? why can't use put
		ByteBuffer byteBuffer = ByteBuffer.wrap(msg.getBytes());

		clientChannel.write(byteBuffer);
		byteBuffer.clear();

		clientChannel.read(byteBuffer);
		String response = new String(byteBuffer.array()).trim();
		byteBuffer.clear();
		return response;
	}
}
