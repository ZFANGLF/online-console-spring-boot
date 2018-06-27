package com.online.console.compments.netty.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;  
import io.netty.channel.ChannelInboundHandlerAdapter;  

@Component
@Qualifier("heartBeatServerHandler")
@ChannelHandler.Sharable
public class HeartBeatServerHandler extends ChannelInboundHandlerAdapter {  
	private static final Logger log = LoggerFactory.getLogger(HeartBeatServerHandler.class);
    @Override  
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
    	log.info("server channelRead..");
    	log.info(ctx.channel().remoteAddress() + "->Server :" + msg.toString());
    }  
  
    @Override  
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {  
        cause.printStackTrace();  
        ctx.close();  
    }  
  
}  