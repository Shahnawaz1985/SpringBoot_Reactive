package com.eric.spring.boot.blockhound.config;

import org.springframework.context.annotation.Configuration;
import org.thymeleaf.TemplateEngine;

import reactor.blockhound.BlockHound.Builder;
import reactor.blockhound.integration.BlockHoundIntegration;

@Configuration
public class BlockHoundConfig implements BlockHoundIntegration {

	@Override
	public void applyTo(Builder builder) {
		builder.disallowBlockingCallsInside(TemplateEngine.class.getCanonicalName(), "process");
	}

}
