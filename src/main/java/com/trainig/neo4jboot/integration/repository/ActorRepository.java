package com.trainig.neo4jboot.integration.repository;

import com.trainig.neo4jboot.integration.model.Actor;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface ActorRepository extends Neo4jRepository<Actor,Long> {

}
