package com.online.console.compments.amqp.sender;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FanoutSender {
	@Autowired
	private AmqpTemplate rabbitTemplate;

	public <T> void sendC2CMessage(T t) {
		this.rabbitTemplate.convertAndSend("C2CFanoutExchange", "", t);
	}
	
	public <T> void sendC2GMessage(T t) {
		this.rabbitTemplate.convertAndSend("C2GFanoutExchange", "", t);
	}
	
	public <T> void sendC2SMessage(T t) {
		this.rabbitTemplate.convertAndSend("C2SFanoutExchange", "", t);
	}
	
	public <T> void sendS2CMessage(T t) {
		this.rabbitTemplate.convertAndSend("S2CFanoutExchange","",t);
	}
}
