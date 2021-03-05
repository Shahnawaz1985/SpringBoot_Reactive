package com.eric.spring.boot.reactice.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.eric.spring.boot.reactive.collections.Cart;



/**
 * 
 * @author Shahnawaz
 *
 */
//@Repository
public interface CartRepository extends ReactiveMongoRepository<Cart, String> {

}
