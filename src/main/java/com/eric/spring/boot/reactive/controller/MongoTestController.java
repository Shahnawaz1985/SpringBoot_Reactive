package com.eric.spring.boot.reactive.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.eric.spring.boot.reactice.repository.CartRepository;
import com.eric.spring.boot.reactice.repository.ItemRepository;

/**
 * 
 * @author Shahnawaz
 *
 */
@Controller
public class MongoTestController {
	
	/*
	 * @Autowired ReactiveMongoOperations operations;
	 */
	
	@Autowired
	private ItemRepository itemRepository;
	
	@Autowired
	private CartRepository cartRepository;
	
	

}
