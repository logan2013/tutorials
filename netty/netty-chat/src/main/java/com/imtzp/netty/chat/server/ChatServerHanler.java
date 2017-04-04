package com.imtzp.netty.chat.server;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.DefaultEventExecutor;

public class ChatServerHanler extends SimpleChannelInboundHandler<String> {

	private static final ChannelGroup CHANNELS = new DefaultChannelGroup(new DefaultEventExecutor());

	@Override
	public void handlerAdded(ChannelHandlerContext ctx) throws Exception {

		System.out.println("incoming..........");

		Channel incoming = ctx.channel();
		for (Channel channel : CHANNELS) {
			channel.write("[SERVER] - " + incoming.remoteAddress() + " has joined!\n");
			channel.flush();
		}
		CHANNELS.add(incoming);
	}

	@Override
	public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {

		System.out.println("removing..........");

		Channel incoming = ctx.channel();
		for (Channel channel : CHANNELS) {
			channel.write("[SERVER] - " + incoming.remoteAddress() + " has left!\n");
			channel.flush();
		}
		CHANNELS.remove(incoming);
	}

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {

		System.out.println("reading..........");

		Channel incoming = ctx.channel();
		for (Channel channel : CHANNELS) {
			if (channel != incoming) {
				channel.write("[" + incoming.remoteAddress() + "] " + msg + "\n");
				channel.flush();
			}
		}
	}

}
