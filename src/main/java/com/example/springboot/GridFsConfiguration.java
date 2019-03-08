package com.example.springboot;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;

@Configuration
public class GridFsConfiguration extends AbstractMongoConfiguration {
    public MongoClient mongoClient(){
        return new MongoClient(new MongoClientURI("mongodb://127.0.0.1:27017/"));
    }
    protected String getDatabaseName(){
        return "bookstore";
    }
    @Bean
    public GridFsTemplate gridFsTemplate(){
        try {
            return new GridFsTemplate(mongoDbFactory(), mappingMongoConverter());
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
