package com.online.console.compments.netty;

import io.netty.channel.ChannelHandler;

public interface ChannelHandlerHolder {  
  
    ChannelHandler[] handlers();  
}  
