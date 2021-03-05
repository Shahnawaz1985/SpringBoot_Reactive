package com.eric.spring.boot.reactive.utils;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Component;

import com.eric.spring.boot.reactive.blocking.repository.BlockingItemRepository;
import com.eric.spring.boot.reactive.collections.Item;

/**
 * 
 * @author Shahnawaz
 *
 */
@Component
public class RepositoryDatabaseLoader {
	
	@Bean
	CommandLineRunner initialize(MongoOperations mongo) {
		return args -> {
			mongo.save(new Item("Alf alarm Clock", 25.77));
			mongo.save(new Item("Smurf TV tray", 29.25));
		};
	}

}
