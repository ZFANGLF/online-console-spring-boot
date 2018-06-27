package com.online.console.compments.netty.channel;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.timeout.IdleStateHandler;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.online.console.compments.netty.handler.AcceptorIdleStateTrigger;
import com.online.console.compments.netty.handler.HeartBeatServerHandler;
import com.online.console.compments.netty.handler.ServerHandler;

@Component
@Qualifier("channelProtocolInitializer")
public class ChannelProtocolInitalizer extends ChannelInitializer<SocketChannel> {

	@Autowired
	ServerHandler serverHandler;

	@Autowired
	HeartBeatServerHandler heartBeatServerHandler;

	@Autowired
	AcceptorIdleStateTrigger idleStateTrigger;
	
	@Autowired
	StringDecoder stringDecoder;
	
	@Autowired
	StringEncoder stringEncoder;

	@Override
	protected void initChannel(SocketChannel ch) throws Exception {
		ChannelPipeline pipeline = ch.pipeline();
		pipeline.addLast(new IdleStateHandler(5, 0, 0, TimeUnit.SECONDS));
		pipeline.addLast(idleStateTrigger);
		pipeline.addLast("decoder",stringDecoder);
		pipeline.addLast("encoder",stringEncoder);
		pipeline.addLast("handler", heartBeatServerHandler);
		pipeline.addLast(serverHandler);
	}

	public ServerHandler getServerHandler() {
		return serverHandler;
	}

	public void setServerHandler(ServerHandler serverHandler) {
		this.serverHandler = serverHandler;
	}

	public HeartBeatServerHandler getHeartBeatServerHandler() {
		return heartBeatServerHandler;
	}

	public void setHeartBeatServerHandler(HeartBeatServerHandler heartBeatServerHandler) {
		this.heartBeatServerHandler = heartBeatServerHandler;
	}

	public AcceptorIdleStateTrigger getIdleStateTrigger() {
		return idleStateTrigger;
	}

	public void setIdleStateTrigger(AcceptorIdleStateTrigger idleStateTrigger) {
		this.idleStateTrigger = idleStateTrigger;
	}

	public StringDecoder getStringDecoder() {
		return stringDecoder;
	}

	public void setStringDecoder(StringDecoder stringDecoder) {
		this.stringDecoder = stringDecoder;
	}

	public StringEncoder getStringEncoder() {
		return stringEncoder;
	}

	public void setStringEncoder(StringEncoder stringEncoder) {
		this.stringEncoder = stringEncoder;
	}
	
	

}