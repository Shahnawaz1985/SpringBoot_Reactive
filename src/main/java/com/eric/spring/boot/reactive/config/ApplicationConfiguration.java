package com.eric.spring.boot.reactive.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@Configuration
//@EntityScan(basePackages = {"com.eric.spring.boot.reactive.collections"})
@EnableAutoConfiguration(exclude={MongoAutoConfiguration.class, MongoDataAutoConfiguration.class})
//@EnableMongoRepositories(basePackages = {"com.eric.spring.boot.reactive.blocking.repository"})
@EnableReactiveMongoRepositories(basePackages = {"com.eric.spring.boot.reactice.repository"})
@ComponentScan(basePackages = {"com.eric.spring.boot.reactive.config.db.mongo", "com.eric.spring.boot.reactive.controller", 
		"com.eric.spring.boot.reactive.service","com.eric.spring.boot.reactive.mongo"})
@EntityScan(basePackages = {"com.eric.spring.boot.reactive.collections"})
public class ApplicationConfiguration {

}
