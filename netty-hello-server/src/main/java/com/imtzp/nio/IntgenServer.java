package com.imtzp.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class IntgenServer {

	private static final int DEFAULT_PORT = 1919;

	public static void main(String[] args) {

		int port;

		try {
			port = Integer.parseInt(args[0]);
		} catch (RuntimeException e) {
			port = DEFAULT_PORT;
		}

		System.out.println("Listening connections on port " + port);

		ServerSocketChannel serverChannel;
		Selector selector;

		try {
			serverChannel = ServerSocketChannel.open();

			ServerSocket ss = serverChannel.socket();
			InetSocketAddress address = new InetSocketAddress(port);
			ss.bind(address);

			serverChannel.configureBlocking(false);

			selector = Selector.open();
			serverChannel.register(selector, SelectionKey.OP_ACCEPT);
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}

		while (true) {

			try {
				selector.select();
			} catch (IOException e) {
				e.printStackTrace();
				break;
			}

			Set<SelectionKey> readyKeys = selector.selectedKeys();
			Iterator<SelectionKey> iterator = readyKeys.iterator();
			while (iterator.hasNext()) {
				SelectionKey key = iterator.next();
				iterator.remove();

				try {
					if (key.isAcceptable()) {
						ServerSocketChannel server = (ServerSocketChannel) key.channel();

						SocketChannel client = server.accept();
						System.out.println("Accpeted connection from " + client);
						client.configureBlocking(false);

						SelectionKey key2 = client.register(selector, SelectionKey.OP_WRITE);

						ByteBuffer output = ByteBuffer.allocate(4);
						output.putInt(0);
						output.flip();

						key2.attach(output);
					} else if (key.isWritable()) {
						SocketChannel client = (SocketChannel) key.channel();

						ByteBuffer output = (ByteBuffer) key.attachment();
						if (!output.hasRemaining()) {
							output.rewind();
							int value = output.getInt();
							output.clear();
							output.putInt(value + 1);
							output.flip();
						}

						client.write(output);
					}
				} catch (IOException e) {
					key.cancel();

					try {
						key.channel().close();
					} catch (IOException e1) {
					}
				}
			}
		}
	}
}
