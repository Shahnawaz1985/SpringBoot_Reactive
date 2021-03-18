package com.eric.spring.boot.reactive.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import org.springframework.web.reactive.config.EnableWebFlux;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
//@EntityScan(basePackages = {"com.eric.spring.boot.reactive.collections"})
@EnableAutoConfiguration(exclude={MongoAutoConfiguration.class, MongoDataAutoConfiguration.class})
//@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
//@EnableMongoRepositories(basePackages = {"com.eric.spring.boot.reactive.blocking.repository"})
@EnableReactiveMongoRepositories(basePackages = {"com.eric.spring.boot.reactice.repository"})
@ComponentScan(basePackages = {"com.eric.spring.boot.reactive.config.db.mongo", "com.eric.spring.boot.reactive.controller", 
		"com.eric.spring.boot.reactive.service","com.eric.spring.boot.reactive.mongo", "com.eric.spring.boot.reactive.webflux.config", "com.eric.spring.boot.reactive.handlers"})
@EntityScan(basePackages = {"com.eric.spring.boot.reactive.collections"})
public class ApplicationConfiguration {
	
	
	@Bean
	public ObjectMapper objectMapper() {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setVisibility(objectMapper.getVisibilityChecker()
		             .withFieldVisibility(JsonAutoDetect.Visibility.ANY));
		return objectMapper;
	}

}
