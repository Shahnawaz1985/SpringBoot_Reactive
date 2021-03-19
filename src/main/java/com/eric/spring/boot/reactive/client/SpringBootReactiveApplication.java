package com.eric.spring.boot.reactive.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import reactor.blockhound.BlockHound;


/**
 * Client for testing Spring Reactive application.
 * @author Shahnawaz
 *
 */
//, exclude = {MongoAutoConfiguration.class, MongoDataAutoConfiguration.class, MongoReactiveAutoConfiguration.class, EmbeddedMongoAutoConfiguration.class})
@SpringBootApplication(scanBasePackages = {"com.eric.spring.boot.reactive.config"})
public class SpringBootReactiveApplication {

	public static void main(String[] args) {
		
		//BlockHound.builder().disallowBlockingCallsInside(TemplateEngine.class.getCanonicalName(), "process").install();
		BlockHound.install();
		
		SpringApplication.run(SpringBootReactiveApplication.class, args);
	}

}
