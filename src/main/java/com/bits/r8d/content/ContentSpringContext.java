package com.bits.r8d.content;

import com.mongodb.Mongo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * Created by alexl on 23/06/2014.
 */
@Configuration
@ComponentScan(basePackages = "com.bits.r8d.content")
public class ContentSpringContext {

    @Bean
    public MongoOperations getMongoOperations() throws Exception {
        return new MongoTemplate(new Mongo("localhost", 27017), "content");
    }
}
