package com.imtzp.netty;

import io.netty.buffer.ByteBuf;

public class BytebufAccessing {

	public static void main(String[] args) {
		ByteBuf byteBuf = null;

		for (int i = 0; i < byteBuf.capacity(); i++) {
			byte b = byteBuf.getByte(i);
			System.out.println((char) i);
		}
	}
}
