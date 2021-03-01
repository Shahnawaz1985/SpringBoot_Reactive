package com.eric.spring.boot.reactive.controller;

import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;

@Controller
public class HomeController {

	Mono<String> home(){
		return Mono.just("home");
	}
}
