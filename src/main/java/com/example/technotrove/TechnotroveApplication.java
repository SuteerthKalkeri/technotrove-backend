package com.example.technotrove;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.technotrove.repository") // JPA repositories
@EnableElasticsearchRepositories(basePackages = "com.example.technotrove.elasticsearch") // Elasticsearch repositories
@EnableCaching
public class TechnotroveApplication {
    public static void main(String[] args) {
        SpringApplication.run(TechnotroveApplication.class, args);
    }
}
