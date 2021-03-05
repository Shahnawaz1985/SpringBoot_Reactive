package com.eric.spring.boot.reactive.utils;

import org.springframework.boot.CommandLineRunner;
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
	
	//@Bean
	CommandLineRunner initialize(BlockingItemRepository repository) {
		return args -> {
			repository.save(new Item("Alf alarm Clock", 25.77));
			repository.save(new Item("Smurf TV tray", 29.25));
		};
	}

}
