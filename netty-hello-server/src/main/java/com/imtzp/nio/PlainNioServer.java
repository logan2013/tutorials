package com.imtzp.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

public class PlainNioServer {

	public void serve(int port) throws IOException {

		ServerSocketChannel serverChannel = ServerSocketChannel.open();
		serverChannel.configureBlocking(false);

		ServerSocket socket = serverChannel.socket();
		InetSocketAddress address = new InetSocketAddress(port);
		socket.bind(address);

		Selector selector = Selector.open();
		serverChannel.register(selector, SelectionKey.OP_ACCEPT);
	}
}
