package com.imtzp.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.Channel;

public class ReferenceCounting {

	public static void main(String[] args) {
		
		Channel channel = null;
		
		ByteBufAllocator alloc = channel.alloc();
		
		ByteBuf buffer = alloc.directBuffer();
		System.out.println(buffer.refCnt());
		
		System.out.println(buffer.release());
	}
}
