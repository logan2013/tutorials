package com.imtzp.nio;

import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.Channels;
import java.nio.channels.WritableByteChannel;
import java.util.concurrent.Future;

public class AsynchronousChannelClient {

	public static void main(String[] args) throws Exception {

		int port = 1717;
		SocketAddress address = new InetSocketAddress(args[0], port);
		AsynchronousSocketChannel client = AsynchronousSocketChannel.open();

		Future<Void> connected = client.connect(address);

		// wait for the connection to finish
		connected.get();

		// read from the connection
		ByteBuffer buffer = ByteBuffer.allocate(74);
		Future<Integer> future = client.read(buffer);

		// do other things...

		// wait for the read to finish
		future.get();

		// flip and drain the buffer
		buffer.flip();

		WritableByteChannel out = Channels.newChannel(System.out);
		out.write(buffer);
	}
}
