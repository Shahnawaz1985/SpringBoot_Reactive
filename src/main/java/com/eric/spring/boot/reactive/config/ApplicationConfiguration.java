package com.eric.spring.boot.reactive.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.eric.spring.boot.reactive.controller", 
		"com.eric.spring.boot.reactive.service",
		"com.eric.spring.boot.reactive.beans"})
public class ApplicationConfiguration {

}
