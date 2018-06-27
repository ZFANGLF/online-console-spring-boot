package com.online.console.compments.amqp.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "S2CQueue")
public class S2CReceiver {
	@RabbitHandler
    public <T> void process(T t) {
        System.out.println("S2C  : " + t);
    }
}
