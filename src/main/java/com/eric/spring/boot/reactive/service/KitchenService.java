package com.eric.spring.boot.reactive.service;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import org.springframework.stereotype.Service;
import com.eric.spring.boot.reactive.beans.Dish;
import reactor.core.publisher.Flux;


/**
 * 
 * @author Shahnawaz
 *
 */
@Service
public class KitchenService {
	
	private List<Dish> menu = Arrays.asList(
			new Dish("Chicken Curry"),
			new Dish("Veg Soup"),
			new Dish("Sweet potato"),
			new Dish("Egg curry"));
	
	private Random picker = new Random();
	
	/**
	 * @return Flux<Dish>
	 */
	public Flux<Dish> getDishes(){
		return Flux.<Dish> generate(sink -> sink.next(randomDish()))
				.delayElements(Duration.ofMillis(250));
	}
	
	/**
	 * @return randomly pick the next Dish
	 */
	private Dish randomDish() {
		return menu.get(picker.nextInt(menu.size()));
	}
			

}
