package com.imtzp.nio;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;

public class PlainOioServer {

	public void serve(int port) throws IOException {

		/**
		 * binds the server to the specified port
		 */
		final ServerSocket socket = new ServerSocket(port);
		try {
			for (;;) {
				/**
				 * Accepts a connection
				 */
				final Socket clientSocket = socket.accept();
				System.out.println("Accepted connection from " + clientSocket);

				/**
				 * Create a new thread to handle the connection
				 */
				(new Thread(new Runnable() {

					@Override
					public void run() {
						OutputStream out;
						try {
							out = clientSocket.getOutputStream();
							/**
							 * Writes the message to the connected client
							 */
							out.write("Hi!\r\n".getBytes(Charset.forName("UTF-8")));
							out.flush();
							/**
							 * Close the connection
							 */
							clientSocket.close();
						} catch (IOException e) {
							e.printStackTrace();
						} finally {
							try {
								clientSocket.close();
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
					}

				})).start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			socket.close();
		}
	}
}
