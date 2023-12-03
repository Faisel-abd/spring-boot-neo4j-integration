package com.trainig.neo4jboot.integration.model;

import org.springframework.data.neo4j.core.schema.*;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.util.List;

@Node("Movie")
@RedisHash("Movie")
public class Movie implements Serializable {

    @Id @GeneratedValue
    private  Long id;
    @Property("title")
    private  String title;

    @Property("released")
    private  int yearOfRelease;

    @Property("tagline")
    private  String shortDescription;

    @Relationship(type = "ACTED_IN", direction = Relationship.Direction.INCOMING)
    private List<Roles> actorsAndRoles;

    @Relationship(type = "DIRECTED", direction = Relationship.Direction.INCOMING)
    private List<Actor> directors;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id= id;
    }

    public String getTitle() {
        return title;
    }

    public int getYearOfRelease() {
        return yearOfRelease;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYearOfRelease(int yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public List<Roles> getActorsAndRoles() {
        return actorsAndRoles;
    }

    public void setActorsAndRoles(List<Roles> actorsAndRoles) {
        this.actorsAndRoles = actorsAndRoles;
    }

    public List<Actor> getDirectors() {
        return directors;
    }

    public void setDirectors(List<Actor> directors) {
        this.directors = directors;
    }
}
