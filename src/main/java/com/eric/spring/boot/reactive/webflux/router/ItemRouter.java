package com.eric.spring.boot.reactive.webflux.router;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.eric.spring.boot.reactive.handlers.ItemHandler;

/**
 * 
 * @author Shahnawaz
 *
 */
@Configuration
public class ItemRouter {
	
	@Bean
	public RouterFunction<ServerResponse> itemRoute(ItemHandler itemHandler) {
    return RouterFunctions
	      .route(RequestPredicates.GET("/item-view").and(RequestPredicates.accept(MediaType.TEXT_HTML)), itemHandler::itemContent);
	  }
	
	
	/**@Bean
    public RouterFunction<ServerResponse> routes(PersonHandler personHandler) {
        return RouterFunctions.route(GET("/people/{id}").and(accept(APPLICATION_JSON)), personHandler::get)
            .andRoute(GET("/people").and(accept(APPLICATION_JSON)), personHandler::all)
            .andRoute(POST("/people").and(accept(APPLICATION_JSON)).and(contentType(APPLICATION_JSON)), personHandler::post)
            .andRoute(PUT("/people/{id}").and(accept(APPLICATION_JSON)).and(contentType(APPLICATION_JSON)), personHandler::put)
            .andRoute(DELETE("/people/{id}"), personHandler::delete)
            .andRoute(GET("/people/country/{country}").and(accept(APPLICATION_JSON)), personHandler::getByCountry);
    }*/

}
