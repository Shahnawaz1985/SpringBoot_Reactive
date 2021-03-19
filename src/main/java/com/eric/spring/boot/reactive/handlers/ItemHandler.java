package com.eric.spring.boot.reactive.handlers;

import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;

/**
 * 
 * @author Shahnawaz
 *
 */
@Component
public class ItemHandler {

	private final Environment environment;

	public ItemHandler(Environment environment) {
		this.environment = environment;
	}
	
	public Mono<ServerResponse> itemContent(ServerRequest request){
		Resource indexResource = new ClassPathResource("/templates/ItemsView.html", getClass().getClassLoader());
		return ServerResponse.ok().contentType(MediaType.TEXT_HTML)
				.body(BodyInserters.fromResource(indexResource));
	}

}
