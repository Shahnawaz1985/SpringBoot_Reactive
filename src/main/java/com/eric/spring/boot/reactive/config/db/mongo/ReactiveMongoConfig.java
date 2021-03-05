package com.eric.spring.boot.reactive.config.db.mongo;

import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.ReactiveMongoDatabaseFactory;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.SimpleReactiveMongoDatabaseFactory;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;




/**
 * 
 * @author Shahnawaz
 *
 */

//@AutoConfigureAfter(EmbeddedMongoAutoConfiguration.class)
public class ReactiveMongoConfig extends AbstractReactiveMongoConfiguration {
	
	
	private final Environment environment;

    public ReactiveMongoConfig(Environment environment) {
        this.environment = environment;
    }

    
    @Bean
    //@DependsOn("embeddedMongoServer")
    public MongoClient mongoClient() {
        //int port = environment.getProperty("local.mongo.port", Integer.class);
    	int port = environment.getProperty("spring.data.mongodb.port", Integer.class);
        String host = environment.getProperty("spring.data.mongodb.host", String.class);
        String database = environment.getProperty("spring.data.mongodb.database", String.class);
        return MongoClients.create(String.format("mongodb://%s:%d/%s", host, port, database));
    	//return MongoClients.create(environment.getProperty("spring.data.mongodb.uri"));
    }

    @Override
    protected String getDatabaseName() {
        return "item-collection";
    }
    
    protected String getMappingBasePackage() {
        return "com.eric.spring.boot.reactive.collections";
    }
    
    
    @Bean
    public ReactiveMongoDatabaseFactory mongoDatabaseFactory() {
    	return new SimpleReactiveMongoDatabaseFactory(mongoClient(), "item-collection");
    }
    
    @Bean
    public ReactiveMongoTemplate mongoTemplate() {
    	return new ReactiveMongoTemplate(mongoDatabaseFactory());
    }
    
}
