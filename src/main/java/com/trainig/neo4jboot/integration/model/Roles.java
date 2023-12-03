package com.trainig.neo4jboot.integration.model;

import org.springframework.data.neo4j.core.schema.RelationshipId;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.util.List;

@RelationshipProperties
@RedisHash("Roles")
public class Roles implements Serializable {

    @RelationshipId
    private  Long id;

    @TargetNode
    private final Actor actor;

    private final List<String> roles;

    public Roles(Actor actor, List<String> roles) {
        this.actor = actor;
        this.roles = roles;
    }

    public Actor getActor() {
        return actor;
    }

    public List<String> getRoles() {
        return roles;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id= id;
    }
}



