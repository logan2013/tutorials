package com.imtzp.nio.async;

import java.io.File;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class AsyncEchoServer {

	private AsynchronousServerSocketChannel serverChannel;
	private Future<AsynchronousSocketChannel> acceptResult;
	private AsynchronousSocketChannel clientChannel;

	public AsyncEchoServer() {

		try {
			serverChannel = AsynchronousServerSocketChannel.open();
			InetSocketAddress hostAddress = new InetSocketAddress("localhost", 4999);

			/**
			 * 传空值时会使用本机地址，并绑定任意一个端口
			 */
			serverChannel.bind(hostAddress);
			acceptResult = serverChannel.accept();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void runServer() {

		try {
			clientChannel = acceptResult.get();
			if ((clientChannel != null) && (clientChannel.isOpen())) {

				/**
				 * 当连接创建完之后，我们可以创建一个循环，在循环里面可以监听进来的消息，并将消息打印回给客户端
				 */
				while (true) {

					ByteBuffer buffer = ByteBuffer.allocate(32);
					Future<Integer> readResult = clientChannel.read(buffer);

					// 此处可以做其它事情
					readResult.get();

					buffer.flip();
					String message = new String(buffer.array()).trim();

					if ("bye".equals(message)) {
						break;
					}

					buffer = ByteBuffer.wrap(new String(message).getBytes());
					Future<Integer> writeResult = clientChannel.write(buffer);

					// 此处可以做其它事情

					writeResult.get();

					buffer.clear();
				}

				clientChannel.close();
				serverChannel.close();
			}
		} catch (InterruptedException | ExecutionException | IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		AsyncEchoServer server = new AsyncEchoServer();
		server.runServer();
	}

	public static Process start() throws IOException, InterruptedException {
		String javaHome = System.getProperty("java.home");
		String javaBin = javaHome + File.separator + "bin" + File.separator + "java";
		String classpath = System.getProperty("java.class.path");
		String className = AsyncEchoServer.class.getCanonicalName();

		ProcessBuilder builder = new ProcessBuilder(javaBin, "-cp", classpath, className);

		return builder.start();
	}
}
