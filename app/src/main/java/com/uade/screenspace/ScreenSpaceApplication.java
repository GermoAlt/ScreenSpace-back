package com.uade.screenspace;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "com.uade.screenspace.repository")
public class ScreenSpaceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScreenSpaceApplication.class, args);
    }

}
