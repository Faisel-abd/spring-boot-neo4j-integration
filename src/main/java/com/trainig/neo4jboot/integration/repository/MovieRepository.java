package com.trainig.neo4jboot.integration.repository;

import com.trainig.neo4jboot.integration.model.Movie;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface MovieRepository  extends Neo4jRepository<Movie,Long> {
}
