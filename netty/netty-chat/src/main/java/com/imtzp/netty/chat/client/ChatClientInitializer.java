package com.imtzp.netty.chat.client;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

public class ChatClientInitializer extends ChannelInitializer<SocketChannel> {

	@Override
	protected void initChannel(SocketChannel ch) throws Exception {

		ChannelPipeline pipline = ch.pipeline();
		pipline.addLast("frameer", new DelimiterBasedFrameDecoder(8192, Delimiters.lineDelimiter()));
		pipline.addLast("decoder", new StringDecoder());
		pipline.addLast("encoder", new StringEncoder());
		
		pipline.addLast("handler", new ClientChannelHandler());
	}

}
