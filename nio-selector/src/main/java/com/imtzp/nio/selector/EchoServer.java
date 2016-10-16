package com.imtzp.nio.selector;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class EchoServer {

	public static void main(String[] args) throws Exception {

		ServerSocketChannel serverChannel = ServerSocketChannel.open();
		serverChannel.bind(new InetSocketAddress(5454));

		serverChannel.configureBlocking(false);
		Selector selector = Selector.open();
		serverChannel.register(selector, SelectionKey.OP_ACCEPT);

		ByteBuffer byteBuffer = ByteBuffer.allocate(256);

		while (true) {
			selector.select();
			Set<SelectionKey> keys = selector.selectedKeys();
			Iterator<SelectionKey> iter = keys.iterator();
			while (iter.hasNext()) {

				SelectionKey readyKey = iter.next();
				if (readyKey.isAcceptable()) {
					SocketChannel clientChannel = serverChannel.accept();

					clientChannel.configureBlocking(false);
					clientChannel.register(selector, SelectionKey.OP_READ);
				}

				if (readyKey.isReadable()) {
					SocketChannel clientChannel = (SocketChannel) readyKey.channel();
					clientChannel.read(byteBuffer);
					
					byteBuffer.flip();
					clientChannel.write(byteBuffer);
					byteBuffer.clear();
				}

				iter.remove();
			}
		}
	}
}
