package com.imtzp.netty;

import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPipeline;

public class ModifyChannelPipeline {

	public static void main(String[] args) {
		ChannelPipeline pipeline = null;

		FirstHandler firstHandler = new FirstHandler();
		pipeline.addLast("handler1", firstHandler);
		pipeline.addFirst("handler2", new SecondHandler());
		pipeline.addLast("handler3", new ThirdHandler());

		pipeline.remove("handler3");
		pipeline.remove(firstHandler);
		pipeline.replace("handler2", "handler4", new FouthHandler());
	}
}

class FirstHandler extends ChannelInboundHandlerAdapter {

}

class SecondHandler extends ChannelOutboundHandlerAdapter {

}

class ThirdHandler extends ChannelOutboundHandlerAdapter {

}

class FouthHandler extends ChannelOutboundHandlerAdapter {

}