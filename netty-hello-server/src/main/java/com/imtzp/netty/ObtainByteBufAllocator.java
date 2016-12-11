package com.imtzp.netty;

import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;

public class ObtainByteBufAllocator {

	public static void main(String[] args) {

		Channel channel = null;
		ByteBufAllocator allocator = channel.alloc();
		
		ChannelHandlerContext ctx = null;
		ByteBufAllocator alloc = ctx.alloc();
	}
}
