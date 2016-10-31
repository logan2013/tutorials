package com.imtzp.nio;

import java.net.SocketOption;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.DatagramChannel;
import java.nio.channels.NetworkChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class OptionSupport {

	public static void main(String[] args) throws Exception {

		printOptions(SocketChannel.open());

		printOptions(ServerSocketChannel.open());

		printOptions(AsynchronousSocketChannel.open());

		printOptions(AsynchronousServerSocketChannel.open());

		printOptions(DatagramChannel.open());
	}

	private static void printOptions(NetworkChannel channel) throws Exception {

		System.out.println(channel.getClass().getSimpleName() + " supports:");
		for (SocketOption<?> option : channel.supportedOptions()) {
			Object optValue = null;
			try {
				optValue = channel.getOption(option);
			} catch (Error e) {
				e.printStackTrace();
			}
			System.out.println(option.name() + ": " + optValue);
		}

		System.out.println();
		channel.close();
	}
}
