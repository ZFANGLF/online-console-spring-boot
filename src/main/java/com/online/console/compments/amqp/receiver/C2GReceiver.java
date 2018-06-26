package com.online.console.compments.amqp.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "C2GQueue")
public class C2GReceiver {
	@RabbitHandler
    public <T> void process(T t) {
        System.out.println("C2G  : " + t);
    }
}
