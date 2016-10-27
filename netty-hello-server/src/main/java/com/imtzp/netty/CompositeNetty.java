package com.imtzp.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.CompositeByteBuf;
import io.netty.buffer.Unpooled;

public class CompositeNetty {

	public static void main(String[] args) {

		CompositeByteBuf messageBuf = Unpooled.compositeBuffer();

		ByteBuf headerBuf = null; // can be backing or direct
		ByteBuf bodyBuf = null; // can be backing or direct

		/**
		 * Appends ByteBuf instances to the CompositeByteBuf
		 */
		messageBuf.addComponents(headerBuf, bodyBuf);

		/**
		 * Removes ByteBuf at index 0(first component)
		 */
		messageBuf.removeComponent(0);// remove the header
		
		for (ByteBuf buf : messageBuf) {
			System.out.println(buf.toString());
		}
	}
}
