package com.imtzp.netty;

import java.net.InetSocketAddress;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class EchoServer {

	private int port;

	public EchoServer(int port) {
		super();
		this.port = port;
	}

	public static void main(String[] args) throws Exception {

		if (args.length != 1) {
			System.err.println("Usage: " + EchoServer.class.getSimpleName() + " <port>");
		}

		int port = Integer.parseInt(args[0]);
		new EchoServer(port).start();
	}

	private void start() throws Exception {

		System.out.println("Begin starting server...");
		
		EchoServerHandler serverHandler = new EchoServerHandler();
		EventLoopGroup group = new NioEventLoopGroup();

		try {
			ServerBootstrap b = new ServerBootstrap();
			b.group(group).channel(NioServerSocketChannel.class).localAddress(new InetSocketAddress(port))
					.childHandler(new ChannelInitializer<SocketChannel>() {

						@Override
						protected void initChannel(SocketChannel ch) throws Exception {
							ch.pipeline().addLast(serverHandler);
						}
					});
			ChannelFuture f = b.bind().sync();
			
			System.out.println("Finish starting server...");

			f.channel().closeFuture().sync();
		} finally {
			group.shutdownGracefully().sync();
		}
	}
}
