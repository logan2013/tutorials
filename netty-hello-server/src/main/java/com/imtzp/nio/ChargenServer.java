package com.imtzp.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class ChargenServer {

	private static final int DEFAULT_PORT = 19;

	public static void main(String[] args) {

		int port;
		try {
			port = Integer.parseInt(args[0]);
		} catch (Exception e) {
			port = DEFAULT_PORT;
		}
		System.out.println("Listening for connections on port " + port);

		byte[] rotation = new byte[95 * 2];
		for (byte i = ' '; i <= '~'; i++) {
			rotation[i - ' '] = i;
			rotation[i + 95 - ' '] = i;
		}

		ServerSocketChannel serverChannel;

		/**
		 * 
		 * you need the selector that allow the server to find all the
		 * connections
		 * 
		 * that are ready to receive input or send output
		 * 
		 * 
		 * you create a Selector that enables
		 * 
		 * that enables the program to iterate over all the connections that are
		 * ready to be processed
		 */
		Selector selector;

		try {
			/**
			 * begin by calling the static factory method
			 * 
			 * ServerSocketChannel.open() to create a ServerSocketChannel object
			 */
			serverChannel = ServerSocketChannel.open();

			/**
			 * to bind it to a port, retrieve its ServerSocket peer object with
			 * the socket() method
			 * 
			 * and then user bind() method on that peer
			 * 
			 */
			ServerSocket ss = serverChannel.socket();
			InetSocketAddress address = new InetSocketAddress(port);
			/**
			 * the server socket channel now listening for incoming connections
			 * on port 19.
			 * 
			 */
			ss.bind(address);

			serverChannel.configureBlocking(false);
			selector = Selector.open();

			/**
			 * you need to register each channel with the selector that monitors
			 * it
			 * 
			 * using the channel's register() method
			 * 
			 * specify the operation you're interested in using a named constant
			 * from the SelectionKey class
			 * 
			 * For the server channel, the only operation of interest is
			 * OP_ACCEPT ; that is, is the server socket channel ready to accept
			 * a new connection?
			 * 
			 */
			serverChannel.register(selector, SelectionKey.OP_ACCEPT);
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}

		int i = 5;
		while (i >= 0) {
			try {
				selector.select();
			} catch (IOException e) {
				e.printStackTrace();
				break;
			}
			
			Set<SelectionKey> readyKeys = selector.selectedKeys();

			Iterator<SelectionKey> iterator = readyKeys.iterator();
			while (iterator.hasNext()) {

				SelectionKey key = iterator.next();
				/**
				 * 必须有
				 */
				iterator.remove();

				try {
					if (key.isAcceptable()) {

						ServerSocketChannel server = (ServerSocketChannel) key.channel();

						/**
						 * call accept() method to accept one connection
						 * 
						 * it returns null almost immediately if there no
						 * incoming connections.
						 * 
						 * be sure to check for that or you will get a nasty
						 * NullPointException when trying to use the socket
						 */
						SocketChannel client = server.accept();

						System.out.println(i + " Accpeted connection from " + client);

						client.configureBlocking(false);
						/**
						 * For the client channels, you want to know something a
						 * little different
						 * 
						 * whether they are ready to have data written onto them
						 * 
						 */
						SelectionKey key2 = client.register(selector, SelectionKey.OP_WRITE);

						ByteBuffer buffer = ByteBuffer.allocate(74);
						
						/**
						 * the position of the buffer is then incremented by length
						 */
						buffer.put(rotation, 0, 72);
						buffer.put((byte) '\r');
						buffer.put((byte) '\n');

						key2.attach(buffer);
					} else if (key.isWritable()) {
						SocketChannel client = (SocketChannel) key.channel();
						
						System.out.println(i + " Writting to connection " + client);
						
						ByteBuffer buffer = (ByteBuffer) key.attachment();

						/**
						 * call hasRemaining() to check whether there's any
						 * unwritten data left in the buffer
						 * 
						 * If there is, write it
						 * 
						 * otherwise, refill the buffer with the next line of
						 * data from the rotation array and write that
						 */
						if (!buffer.hasRemaining()) {
							
							/**
							 * reset the buffer postion to zero
							 */
							buffer.rewind();

							/**
							 * buffer.get() reads the first byte of data from
							 * the buffer, and then increments 1 postion
							 */
							int first = buffer.get();
							
							System.out.println("First byte of buffer " + first);
							
							buffer.rewind();
							int position = first - ' ' + 1;
							buffer.put(rotation, position, 72);
							buffer.put((byte) '\r');
							buffer.put((byte) '\n');
							buffer.flip();
						}

						 client.write(buffer);
					}
				} catch (IOException e) {

					/**
					 * cancel the key and close the responding channel
					 * 
					 */
					key.cancel();

					try {
						key.channel().close();
					} catch (IOException e1) {
					}
				}
			}
		
			i--;
		}

	}
}
