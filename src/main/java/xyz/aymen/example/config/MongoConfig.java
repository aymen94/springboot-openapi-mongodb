package xyz.aymen.example.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = {"xyz.aymen.example.repository"})
public class MongoConfig {

}