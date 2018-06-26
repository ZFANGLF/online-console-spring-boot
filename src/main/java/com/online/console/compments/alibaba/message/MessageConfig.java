package com.online.console.compments.alibaba.message;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageConfig {
	// 
	@Value("${alibaba.message.product}")
	static String product;
	
	@Value("${alibaba.message.domain}")
	static String domain;
	
	@Value("${alibaba.message.access.key.id}")
	static String accessKeyId;
	
	@Value("${alibaba.message.access.key.secret}")
	static String accessKeySecret;
	
	@Value("${alibaba.message.sign.name}")
	private String signName;
	
	@Value("${alibaba.message.template.code01}")
	private String TemplateCode = "SMS_129759877";
	
	@Value("${alibaba.message.connect.timeout}")
	private String defaultConnectTimeOut;
	
	@Value("${alibaba.message.read.timeout}")
	private String defaultReadTimeOut;

}
