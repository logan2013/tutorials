package com.imtzp.netty.chat.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class ChatServer {

	private final int port;

	public ChatServer(int port) {
		this.port = port;
	}

	public static void main(String[] args) throws Exception {
		new ChatServer(8000).run();
	}

	public void run() throws Exception {
		EventLoopGroup bossGroup = new NioEventLoopGroup();
		EventLoopGroup workerGroup = new NioEventLoopGroup();

		try {
			ServerBootstrap bootstrap = new ServerBootstrap().group(bossGroup, workerGroup)
					.channel(NioServerSocketChannel.class).childHandler(new ChatServerInitializer());

			bootstrap.bind(port).sync().channel().closeFuture().sync();
		} finally {
			bossGroup.shutdownGracefully();
			workerGroup.shutdownGracefully();
		}
	}
}
