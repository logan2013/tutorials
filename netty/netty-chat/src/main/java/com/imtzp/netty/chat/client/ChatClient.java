package com.imtzp.netty.chat.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

public class ChatClient {

	private final String host;
	private final int port;

	public ChatClient(String host, int port) {
		this.host = host;
		this.port = port;
	}

	public static void main(String[] args) throws Exception {
		new ChatClient("localhost", 8000).run();
	}

	public void run() throws Exception {

		EventLoopGroup group = new NioEventLoopGroup();

		try {
			Bootstrap bootstrap = new Bootstrap().group(group).channel(NioSocketChannel.class)
					.handler(new ChatClientInitializer());
			Channel channel = bootstrap.connect(host, port).sync().channel();

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			while (true) {
				String line = br.readLine();
				channel.write(line + "\r\n");
				System.out.println("sending...............");
				channel.flush();
			}
		} finally {
			group.shutdownGracefully();
		}
	}
}
