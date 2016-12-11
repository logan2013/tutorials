package com.imtzp.nio.async;

import java.io.File;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.HashMap;
import java.util.Map;

public class AsyncEchoServer2 {

	private AsynchronousServerSocketChannel serverChannel;
	private AsynchronousSocketChannel clientChannel;

	public AsyncEchoServer2() {

		try {
			serverChannel = AsynchronousServerSocketChannel.open();
			InetSocketAddress hostAddress = new InetSocketAddress("localhost", 4999);
			serverChannel.bind(hostAddress);

			/**
			 * while循环是为了防止服务器在客户端建立连接之前退出
			 */
			while (true) {
				serverChannel.accept(null, new CompletionHandler<AsynchronousSocketChannel, Object>() {

					/**
					 * 当一个新的连接建立之后会调用completed方法
					 */
					@Override
					public void completed(AsynchronousSocketChannel result, Object attachment) {

						/**
						 * 如果AsynchronousServerSocketChannel还是打开的话，重新调用accept方法，
						 * 准备调用下一个连接，使用同一个CompletionHandler实例
						 */
						if (serverChannel.isOpen()) {
							serverChannel.accept(null, this);
						}

						clientChannel = result;
						if ((clientChannel != null) && (clientChannel.isOpen())) {
							ReadWriteHandler handler = new ReadWriteHandler();
							ByteBuffer buffer = ByteBuffer.allocate(32);

							Map<String, Object> readInfo = new HashMap<>();
							readInfo.put("action", "read");
							readInfo.put("buffer", buffer);

							/**
							 * 第一个执行的操作是读，因为这是一个回显server，它响应客户端的消息
							 */
							clientChannel.read(buffer, readInfo, handler);
						}
					}

					@Override
					public void failed(Throwable exc, Object attachment) {

					}
				});

				try {
					/**
					 * 为了防止无限循环，在最后调用System.in.read()，直到进来的连接读取标准输入
					 */
					System.in.read();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	class ReadWriteHandler implements CompletionHandler<Integer, Map<String, Object>> {

		@Override
		public void completed(Integer result, Map<String, Object> attachment) {
			Map<String, Object> actionInfo = attachment;
			String action = (String) actionInfo.get("action");

			if ("read".equals(action)) {
				/**
				 * 如果是读操作结束，执行写操作，将消息写回客户端
				 */
				ByteBuffer buffer = (ByteBuffer) actionInfo.get("buffer");
				buffer.flip();
				actionInfo.put("action", "write");

				clientChannel.write(buffer, actionInfo, this);

				buffer.clear();
			} else if ("write".equals(action)) {
				/**
				 * 如果是写操作结束，重新调用read方法，准备接收下一条消息
				 */

				ByteBuffer buffer = ByteBuffer.allocate(32);
				actionInfo.put("action", "read");
				actionInfo.put("buffer", buffer);

				clientChannel.read(buffer, actionInfo, this);
			}
		}

		@Override
		public void failed(Throwable exc, Map<String, Object> attachment) {

		}
	}

	public static void main(String[] args) {
		new AsyncEchoServer2();
	}

	public static Process start() throws IOException, InterruptedException {
		String javaHome = System.getProperty("java.home");
		String javaBin = javaHome + File.separator + "bin" + File.separator + "java";
		String classpath = System.getProperty("java.class.path");
		String className = AsyncEchoServer2.class.getCanonicalName();

		ProcessBuilder builder = new ProcessBuilder(javaBin, "-cp", classpath, className);

		return builder.start();
	}
}
