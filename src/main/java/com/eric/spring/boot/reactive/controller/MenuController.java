package com.eric.spring.boot.reactive.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
	
	/**
	 * @return Flux<Dish>
	 */
	@GetMapping(value = "/dish-finder", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Dish> serveDishes(){
		return this.kitchenService.getDishes();
	}
	
	/**@GetMapping(value = "/dish-finder-flux", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public ResponseEntity<Flux<Dish>> servesDishes(){
		Flux<Dish> servedDish = this.kitchenService.getDishes();
		
		HttpHeaders responseHeaders = new HttpHeaders();
	    responseHeaders.set("Cache-Control", "no-transform");
		return ResponseEntity.ok()
			      //.headers(responseHeaders)
			      .body(servedDish);
	}*/
	
	/**
	 * @return Flux<Dish>
	 */
	@GetMapping(value = "/delivered-dishes", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Dish> deliveredDishes(){
		return this.kitchenService.getDishes()
				.map(dish -> Dish.deliver(dish));
	}

}
