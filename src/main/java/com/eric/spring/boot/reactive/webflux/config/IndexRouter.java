package com.eric.spring.boot.reactive.webflux.config;

import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.eric.spring.boot.reactive.handlers.IndexHandler;

/**
 * 
 * @author Shahnawaz
 *
 */
@Configuration
public class IndexRouter {

	@Bean
	public RouterFunction<ServerResponse> route(IndexHandler indexHandler) {
    return RouterFunctions
	      .route(RequestPredicates.GET("/").and(RequestPredicates.accept(MediaType.TEXT_HTML)), indexHandler::home);
	  }
	
	/**
	 * Router Function for static content.
	 * @return
	 */
	@Bean
	public RouterFunction<ServerResponse> staticContentRouter() {
		Resource staticResource = new ClassPathResource("static/", getClass().getClassLoader());
	    return RouterFunctions
	      .resources("/**", staticResource);
	}
	
	
}
