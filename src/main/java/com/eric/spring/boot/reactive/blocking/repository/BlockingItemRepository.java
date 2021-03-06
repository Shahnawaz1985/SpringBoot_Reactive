package com.eric.spring.boot.reactive.blocking.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.eric.spring.boot.reactive.collections.Items;

/**
 * 
 * @author Shahnawaz
 *
 */
@Repository
public interface BlockingItemRepository extends MongoRepository<Items, String> {

}
