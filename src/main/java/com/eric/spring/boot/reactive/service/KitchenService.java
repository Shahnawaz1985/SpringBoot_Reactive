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
			new Dish("Egg curry"),
			new Dish("Fish Fry"),
			new Dish("Chilly Potato"),
			new Dish("Veg Manchurian"));
	
	private Random picker = new Random();
	
	/**
	 * @return Flux<Dish>
	 */
	public Flux<Dish> getDishes(){
		return Flux.<Dish> generate(sink -> sink.next(randomDish()))
				.delayElements(Duration.ofMillis(250));
	}
	
	
	public Flux<Dish> getDishesWithInterval(){
		return Flux.interval(Duration.ofSeconds(2))
				.onBackpressureDrop()
				.map(interval -> randomDish());
				//.flatMapIterable(dish -> dish);
	}
	
	/**
	 * @return randomly pick the next Dish
	 */
	private Dish randomDish() {
		return menu.get(picker.nextInt(menu.size()));
	}
			

}
