package com.imtzp.nio;

import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.Channels;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class HttpSoapServer {

	/**
	 * Sample codes
	 * 
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws Exception {
		
		ServerSocketChannel server = null;
		
		SocketChannel channel = server.accept();
		/**
		 * 处理HTTP头部信息
		 */
		parseHttpHeader(channel);
		
		XMLReader parser = XMLReaderFactory.createXMLReader();
		
		ContentHandler contentHandler = null;
		parser.setContentHandler(contentHandler);
		
		InputStream in = Channels.newInputStream(channel);
		parser.parse(new InputSource(in));
		
	}

	private static void parseHttpHeader(SocketChannel channel) {
		
	}
}
