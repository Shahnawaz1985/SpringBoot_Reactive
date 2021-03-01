package com.eric.spring.boot.reactive.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.eric.spring.boot.reactive.config"})
public class SpringBootReactiveApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootReactiveApplication.class, args);
	}

}
