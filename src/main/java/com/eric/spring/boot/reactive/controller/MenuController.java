package com.eric.spring.boot.reactive.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eric.spring.boot.reactive.beans.Dish;
import com.eric.spring.boot.reactive.service.KitchenService;
import reactor.core.publisher.Flux;

/**
 * 
 * @author Shahnawaz
 *
 */
@RestController
public class MenuController {
	
	@Autowired
	private KitchenService kitchenService;
	
	@GetMapping(value = "/kitchen-server", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Dish> serveDishes(){
		return kitchenService.getDishes();
	}

}
