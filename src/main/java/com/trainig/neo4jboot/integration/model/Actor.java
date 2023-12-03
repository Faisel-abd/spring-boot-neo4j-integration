package com.trainig.neo4jboot.integration.model;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Node("Person")
@RedisHash("Person")
public class Actor implements Serializable {

    @Id @GeneratedValue
    private  Long id;

    @Property("name")
    private String name;
    @Property("born")
    private int yearBirth;


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getYearBirth() {
        return yearBirth;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setYearBirth(int yearBirth) {
        this.yearBirth = yearBirth;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
