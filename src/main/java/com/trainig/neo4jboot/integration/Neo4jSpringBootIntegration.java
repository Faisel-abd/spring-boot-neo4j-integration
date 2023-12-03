package com.trainig.neo4jboot.integration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
@EnableCaching
public class Neo4jSpringBootIntegration {

    public static void main(String[] args) {
        SpringApplication.run(Neo4jSpringBootIntegration.class, args);
    }

}
