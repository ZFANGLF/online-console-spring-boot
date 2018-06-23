package com.nexcool.console.compments.netty.channel;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.nexcool.console.compments.netty.handler.EchoServerHandler;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.timeout.IdleStateHandler;

//ChannelInitializer是默认的initializer，因此需要继承ChannelInitializer类来实现自己的initializer
@Component
@Qualifier("channleInitialize")
public class ChannelInit extends ChannelInitializer<SocketChannel> {
	private static final int MAX_IDLE_SECONDS = 60;

	public ChannelInit() {
	}

	@Override
	protected void initChannel(SocketChannel ch) throws Exception {
		// 添加到pipeline中的handler会被串行处理(PS: 类似工业生产中的流水线)
		ChannelPipeline pipeline = ch.pipeline();
		 pipeline.addLast("idleStateCheck", new IdleStateHandler(MAX_IDLE_SECONDS,
		 MAX_IDLE_SECONDS, MAX_IDLE_SECONDS));
		// 使用addLast来添加自己定义的handler到pipeline中
		// pipeline.addLast("multiplexer", createMyProtcolDecoder());
		pipeline.addLast(new EchoServerHandler());
	}
}
