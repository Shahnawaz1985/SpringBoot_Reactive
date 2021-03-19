package com.eric.spring.boot.reactive.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eric.spring.boot.reactice.repository.CartsRepository;
import com.eric.spring.boot.reactice.repository.ItemsRepository;
import com.eric.spring.boot.reactive.collections.CartItem;
import com.eric.spring.boot.reactive.collections.Carts;
import com.eric.spring.boot.reactive.collections.Items;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * 
 * @author Shahnawaz
 *
 */
@RestController
public class MongoReactiveController {

	/*
	 * @Autowired ReactiveMongoOperations operations;
	 */

	@Autowired
	private ItemsRepository itemRepository;

	@Autowired
	private CartsRepository cartRepository;

	@GetMapping(value = "/items-check", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public ResponseEntity<Flux<Items>> items() {
		Flux<Items> resultItems = this.itemRepository.findAll();
		//return ResponseEntity.ok().body(Mono.just(Rendering.view("ItemsView.html").modelAttribute("items", resultItems)
			//	.modelAttribute("cart", resultCarts).build()));
		return ResponseEntity.ok().body(resultItems);
	}
	
	@GetMapping(value = "/cart-check", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public ResponseEntity<Flux<Carts>> carts() {
		Flux<Carts> resultCarts = this.cartRepository.findAll().defaultIfEmpty(new Carts("My Cart"));
		//return ResponseEntity.ok().body(Mono.just(Rendering.view("ItemsView.html").modelAttribute("items", resultItems)
			//	.modelAttribute("cart", resultCarts).build()));
		return ResponseEntity.ok().body(resultCarts);
	}

	
	@PostMapping("/add/{id}") // <1>
	Mono<String> addToCart(@PathVariable String id) { 
		return this.cartRepository.findById("My Cart") 
				.defaultIfEmpty(new Carts("My Cart")) 
				.flatMap(cart -> cart.getCartItems().stream() 
						.filter(cartItem -> cartItem.getItem() 
								.getId().equals(id)) 
						.findAny() 
						.map(cartItem -> {
							cartItem.increment();
							return Mono.just(cart);
						}) //
						.orElseGet(() -> { 
							return this.itemRepository.findById(id) 
									.map(item -> new CartItem(item)) 
									.map(cartItem -> {
										cart.getCartItems().add(cartItem);
										return cart;
									});
						}))
				.flatMap(cart -> this.cartRepository.save(cart)) 
				.thenReturn("redirect:/"); 
	}
	

	@PostMapping
	Mono<String> createItem(@ModelAttribute Items newItem) {
		return this.itemRepository.save(newItem) 
				.thenReturn("redirect:/");
	}

	@DeleteMapping("/delete/{id}")
	Mono<String> deleteItem(@PathVariable String id) {
		return this.itemRepository.deleteById(id) 
				.thenReturn("redirect:/");
	}
	
	
	@ModelAttribute("items")
	public Flux<Items> populateItem() {
		return  this.itemRepository.findAll();
	  }
	 
	
	@ModelAttribute("cart")
	public Flux<Carts> populateCart() {
		return this.cartRepository.findAll();
	  }
	
	@ModelAttribute("myCartItems")
	public Flux<List<CartItem>> populateCartItems() {
       Collection<Carts> carts = (Collection<Carts>) this.cartRepository.findAll();
       List<CartItem> cartItems = null;
       if(null != carts) {
    	   for(Carts c : carts) {
    		   if(c.getId().equals("My Object")) {
    			   if(null != c.getCartItems()) {
    				   cartItems = c.getCartItems();
    			   }
    		   }
    	   }
       }
       if(null != cartItems && cartItems.size() > 0) {
    	   return Flux.just(cartItems);
       }else {
    	   return null;
       }
	}
   			   
}
