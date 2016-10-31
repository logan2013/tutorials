package com.imtzp.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.CompletionHandler;
import java.nio.channels.WritableByteChannel;

public class LineHandler implements CompletionHandler<Integer, ByteBuffer> {

	@Override
	public void completed(Integer result, ByteBuffer buffer) {
		buffer.flip();
		WritableByteChannel out = Channels.newChannel(System.out);
		try {
			out.write(buffer);
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}

	@Override
	public void failed(Throwable exc, ByteBuffer buffer) {
		System.err.println(exc.getMessage());
	}

}
