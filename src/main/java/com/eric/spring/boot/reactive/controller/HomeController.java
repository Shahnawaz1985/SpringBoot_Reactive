package com.eric.spring.boot.reactive.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
public class HomeController {

	@GetMapping(value = "/")
	public Mono<String> home(){
		return Mono.just("home");
	}
}
