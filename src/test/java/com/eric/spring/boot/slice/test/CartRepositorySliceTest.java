package com.eric.spring.boot.slice.test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo;
import org.springframework.boot.test.context.SpringBootTest;

import com.eric.spring.boot.reactice.repository.CartsRepository;
import com.eric.spring.boot.reactive.collections.CartItem;
import com.eric.spring.boot.reactive.collections.Carts;

import reactor.test.StepVerifier;

/**
 * 
 * @author Shahnawaz
 *
 */
@SpringBootTest(classes = {com.eric.spring.boot.reactive.test.config.ApplicationConfiguration.class})
@AutoConfigureDataMongo
public class CartRepositorySliceTest {
	
	@Autowired
	private CartsRepository repository;
	
	@Test
	public void cartsRepositorySavesCart() {
		
		Carts sampleCart = new Carts("my-cart", new ArrayList<CartItem>());
		
		repository.save(sampleCart)
			.as(StepVerifier::create)
			.expectNextMatches(item -> {
				assertThat(sampleCart.getId()).isEqualTo("my-cart");
				assertThat(sampleCart.getCartItems().size()).isEqualTo(0);
				return true;
			})
			.verifyComplete();
	}
}
