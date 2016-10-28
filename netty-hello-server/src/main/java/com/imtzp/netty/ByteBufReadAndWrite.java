package com.imtzp.netty;

import java.nio.charset.Charset;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

public class ByteBufReadAndWrite {

	public static void main(String[] args) {
		Charset utf8 = Charset.forName("UTF-8");
		ByteBuf buf = Unpooled.copiedBuffer("Netty in Action rocks!", utf8);

		int readerIndex = buf.readerIndex();
		int writerIndex = buf.writerIndex();

		System.out.println((char) buf.readByte());

		System.out.println(readerIndex == buf.readerIndex());
		System.out.println(writerIndex == buf.writerIndex());

		readerIndex = buf.readerIndex();
		writerIndex = buf.writerIndex();

		buf.writeByte((byte) '?');

		System.out.println(readerIndex == buf.readerIndex());
		System.out.println(writerIndex == buf.writerIndex());
	}
}
