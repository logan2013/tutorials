package com.imtzp.netty;

import java.nio.ByteBuffer;

public class CompositeNio {

	public static void main(String[] args) {
		
		ByteBuffer header = null;
		ByteBuffer body = null;
		
		ByteBuffer message = ByteBuffer.allocate(header.remaining() + body.remaining());
		message.put(header);
		message.put(body);
		
		message.flip();
	}
}
