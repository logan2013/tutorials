package com.imtzp.netty;

import java.nio.charset.Charset;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

public class SliceAByteBuf {

	public static void main(String[] args) {
		Charset utf8 = Charset.forName("UTF-8");

		ByteBuf byteBuf = Unpooled.copiedBuffer("Netty in Action rocks!", utf8);

		System.out.println("--------init ByteBuf----------");

		System.out.println(byteBuf.readerIndex());
		// 14?？
		System.out.println(byteBuf.writerIndex());

		ByteBuf sliced = byteBuf.slice(0, 14);

		System.out.println("--------after slice----------");

		System.out.println(sliced.readerIndex());
		System.out.println(sliced.writerIndex());

		System.out.println(sliced.toString(utf8));

		System.out.println(sliced.readerIndex());
		System.out.println(sliced.writerIndex());

		// This method does not modify readerIndex or writerIndex of this
		// buffer.
		byteBuf.setByte(0, (byte) 'J');

		System.out.println("--------after setByte----------");

		System.out.println(byteBuf.readerIndex());
		System.out.println(byteBuf.writerIndex());

		System.out.println(sliced.readerIndex());
		System.out.println(sliced.writerIndex());

		System.out.println(byteBuf.getByte(0) == sliced.getByte(0));
	}
}
