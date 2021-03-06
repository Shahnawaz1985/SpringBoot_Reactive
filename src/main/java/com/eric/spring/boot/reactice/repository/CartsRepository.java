package com.eric.spring.boot.reactice.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.eric.spring.boot.reactive.collections.Carts;



/**
 * 
 * @author Shahnawaz
 *
 */
//@Repository
public interface CartsRepository extends ReactiveCrudRepository<Carts, String> {

}
