package com.online.console.compments.amqp.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AMQPConfig {
	// *****************************************************************//
	// *****************************************************************//
	// *************************-----Queue-----**************************//
	// *****************************************************************//
	// *****************************************************************//
	/**
	 * @Title: C2CQueue 
	 * @Description: 用户单聊 
	 * @return Queue 返回类型 
	 * @throws
	 **/
	@Bean(name = "C2CQueue")
	public Queue C2CQueue() {
		return new Queue("C2C");
	}

	/**
	 * @Title: C2GQueque 
	 * @Description: 用户群聊 
	 * @return Queue 返回类型 
	 * @throws
	 **/
	@Bean(name = "C2GQueue")
	public Queue C2GQueque() {
		return new Queue("C2G");
	}

	/**
	 * @Title: C2SQueque 
	 * @Description: 用户上报 
	 * @return Queue 返回类型 
	 * @throws
	 **/
	@Bean(name = "C2SQueue")
	public Queue C2SQueque() {
		return new Queue("C2S");
	}

	/**
	 * @Title: S2CQueque 
	 * @Description: 系统推送 
	 * @return Queue 返回类型 
	 * @throws
	 **/
	@Bean(name = "S2CQueue")
	public Queue S2CQueque() {
		return new Queue("S2C");
	}

	// *****************************************************************//
	// *****************************************************************//
	// ********************-----Fanout Exchange-----********************//
	// *****************************************************************//
	// *****************************************************************//
	
	@Bean(name="C2CExchange")
	public FanoutExchange C2CFanoutExchange() {
		return new FanoutExchange("C2CExchange");
	}
	
	@Bean(name="C2GExchange")
	public FanoutExchange C2GFanoutExchange() {
		return new FanoutExchange("C2GExchange");
	}
	
	@Bean(name="C2SExchange")
	public FanoutExchange C2SFanoutExchange() {
		return new FanoutExchange("C2SExchange");
	}
	
	@Bean(name="S2CExchange")
	public FanoutExchange S2CFanoutExchange() {
		return new FanoutExchange("S2CExchange");
	}

	@Bean
	  Binding C2CBindingExchange(Queue C2CQueue,FanoutExchange C2CFanoutExchange) {
	    return BindingBuilder.bind(C2CQueue).to(C2CFanoutExchange);
	  }
	
	@Bean
	  Binding C2GBindingExchange(Queue C2GQueue,FanoutExchange C2GFanoutExchange) {
	    return BindingBuilder.bind(C2GQueue).to(C2GFanoutExchange);
	  }
	
	@Bean
	  Binding C2SBindingExchange(Queue C2SQueue,FanoutExchange C2SFanoutExchange) {
	    return BindingBuilder.bind(C2SQueue).to(C2SFanoutExchange);
	  }
	
	@Bean
	  Binding S2CBindingExchange(Queue S2CQueue,FanoutExchange S2CFanoutExchange) {
	    return BindingBuilder.bind(S2CQueue).to(S2CFanoutExchange);
	  }
}
