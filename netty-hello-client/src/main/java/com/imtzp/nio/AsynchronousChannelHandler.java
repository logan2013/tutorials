package com.imtzp.nio;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

public class AsynchronousChannelHandler {

	public static void main(String[] args) {
		ByteBuffer buffer = ByteBuffer.allocate(74);
		CompletionHandler<Integer, ByteBuffer> handler = new LineHandler();
		
		AsynchronousSocketChannel channel = null;
		channel.read(buffer, buffer, handler);
	}
}
