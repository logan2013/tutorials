package com.imtzp.netty;

import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPipeline;
import io.netty.util.CharsetUtil;

public class ChannelHandlerContextMain {

	public void accessChannel() {
		ChannelHandlerContext ctx = null;

		Channel channel = ctx.channel();

		/**
		 * Calling write() on the channel causes a write event to flow all the
		 * way through the pipeline
		 */
		channel.write(Unpooled.copiedBuffer("Netty in Action", CharsetUtil.UTF_8));
	}
	
	public void accessChannelPipeline() {
		
		ChannelHandlerContext ctx = null;
		
		ChannelPipeline pipeline = ctx.pipeline();

		pipeline.write(Unpooled.copiedBuffer("Netty in Action", CharsetUtil.UTF_8));
	}
}
