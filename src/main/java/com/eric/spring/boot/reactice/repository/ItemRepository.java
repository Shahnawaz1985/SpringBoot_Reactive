package com.eric.spring.boot.reactice.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.eric.spring.boot.reactive.collections.Item;

/**
 * 
 * @author Shahnawaz
 *
 */
//@Repository
public interface ItemRepository extends ReactiveCrudRepository<Item, String> {

}
