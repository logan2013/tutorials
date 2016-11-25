package com.imtzp.ws;

import java.awt.Dimension;
import java.io.ByteArrayOutputStream;

import javax.imageio.ImageIO;

import com.github.sarxos.webcam.Webcam;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.BinaryWebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.util.concurrent.GlobalEventExecutor;

public class Application {

	private static final String WEBSOCKET_PATH = "/websocket";
	private static final int FPS = 30;

	public static void main(String[] args) throws Exception {

		ChannelGroup allChannelGroup = new DefaultChannelGroup("all", GlobalEventExecutor.INSTANCE);

		startCapture(allChannelGroup);
		startServer(allChannelGroup);
	}

	private static void startCapture(ChannelGroup group) {
		Webcam webcam = Webcam.getDefault();
		webcam.setViewSize(new Dimension(640, 480));
		webcam.open();

		new Thread(() -> {

			while (true) {
				try {
					ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
					ImageIO.write(webcam.getImage(), "jpg", outputStream);
					group.writeAndFlush(new BinaryWebSocketFrame(Unpooled.copiedBuffer(outputStream.toByteArray())));

					Thread.sleep(1000 / FPS);
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
			}

		}).start();
	}

	private static void startServer(ChannelGroup group) throws Exception {

		EventLoopGroup bossGroup = new NioEventLoopGroup(1);

		EventLoopGroup workerGroup = new NioEventLoopGroup();

		try {
			new ServerBootstrap().group(bossGroup, workerGroup).channel(NioServerSocketChannel.class)
					.handler(new LoggingHandler(LogLevel.INFO)).childHandler(new ChannelInitializer<SocketChannel>() {

						@Override
						protected void initChannel(SocketChannel ch) throws Exception {
							ch.pipeline().addLast(new HttpServerCodec()).addLast(new HttpObjectAggregator(65536))
									.addLast(new WebSocketServerProtocolHandler(WEBSOCKET_PATH, null, true))
									.addLast(new WebSocketFrameHandler(group));
						}
					}).bind(8080).sync().channel().closeFuture().sync();
		} finally {
			bossGroup.shutdownGracefully();
			workerGroup.shutdownGracefully();
		}
	}
}

class WebSocketFrameHandler extends SimpleChannelInboundHandler<WebSocketFrame> {

	private ChannelGroup group;

	public WebSocketFrameHandler(ChannelGroup group) {
		this.group = group;
	}

	@Override
	public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
		if (evt == WebSocketServerProtocolHandler.ServerHandshakeStateEvent.HANDSHAKE_COMPLETE) {
			group.add(ctx.channel());
		} else {
			super.userEventTriggered(ctx, evt);
		}
	}

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, WebSocketFrame msg) throws Exception {
		// do nothing
	}
}