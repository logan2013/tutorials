package com.imtzp.netty;

import java.nio.charset.Charset;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

public class CopyingAByteBuf {

	public static void main(String[] args) {
		Charset utf8 = Charset.forName("UTF-8");
		ByteBuf buf = Unpooled.copiedBuffer("Netty in Action rocks!", utf8);

		ByteBuf copy = buf.copy(0, 14);

		System.out.println("----------after copy---------");
		System.out.println(copy.readerIndex());
		System.out.println(copy.writerIndex());

		System.out.println(copy.toString(utf8));

		buf.setByte(0, (byte) 'J');

		System.out.println(buf.getByte(0) == copy.getByte(0));
	}
}
