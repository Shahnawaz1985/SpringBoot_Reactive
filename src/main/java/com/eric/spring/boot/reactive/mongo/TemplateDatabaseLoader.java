package com.eric.spring.boot.reactive.mongo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;
import org.springframework.stereotype.Component;

import com.eric.spring.boot.reactive.collections.Items;

/**
 * 
 * @author Shahnawaz
 *
 */
@Component
public class TemplateDatabaseLoader {
	
	@Bean
	CommandLineRunner initialize(ReactiveMongoOperations mongo) {
		return args -> {
			mongo.save(new Items("Alf Alarm Clock - 2", 34.98));
			mongo.save(new Items("Smurf TV tray - 2", 44.98));
		};
	}

}
