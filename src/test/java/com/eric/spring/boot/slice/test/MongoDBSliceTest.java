package com.eric.spring.boot.slice.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo;
import org.springframework.boot.test.context.SpringBootTest;

import com.eric.spring.boot.reactice.repository.ItemsRepository;
import com.eric.spring.boot.reactive.collections.Items;

import reactor.test.StepVerifier;

/**
 * 
 * @author Shahnawaz
 *
 */
@SpringBootTest(classes = {com.eric.spring.boot.reactive.test.config.ApplicationConfiguration.class})
@AutoConfigureDataMongo
public class MongoDBSliceTest {
	
	@Autowired
	private ItemsRepository repository;
	
	@Test
	public void itemRepositorySavesItems() {
		
		Items sampleItem = new Items("name", 1.99);
		
		repository.save(sampleItem)
			.as(StepVerifier::create)
			.expectNextMatches(item -> {
				assertThat(item.getId()).isNotNull();
				assertThat(item.getName()).isEqualTo("name");
				assertThat(item.getPrice()).isEqualTo(1.99);
				return true;
			})
			.verifyComplete();
	}

}
