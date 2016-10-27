package com.imtzp.netty;

import io.netty.buffer.CompositeByteBuf;
import io.netty.buffer.Unpooled;

public class CompositeBufAccessing {

	public static void main(String[] args) {
		
		CompositeByteBuf comBuf = Unpooled.compositeBuffer();
		int length = comBuf.readableBytes();
		
		byte[] array = new byte[length];
		comBuf.getBytes(comBuf.readerIndex(), array);
		
		handleArray(array, 0, array.length);
	}

	private static void handleArray(byte[] array, int offset, int length) {
		
	}
}
