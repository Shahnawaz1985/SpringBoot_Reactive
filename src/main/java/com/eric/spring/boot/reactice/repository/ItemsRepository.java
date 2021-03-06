package com.eric.spring.boot.reactice.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.eric.spring.boot.reactive.collections.Items;

/**
 * 
 * @author Shahnawaz
 *
 */
//@Repository
public interface ItemsRepository extends ReactiveCrudRepository<Items, String> {

}
