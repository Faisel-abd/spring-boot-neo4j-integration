package com.trainig.neo4jboot.integration.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@NoArgsConstructor
@Data
public class ActorDTO implements Serializable {
    @JsonIgnore
    private Long id;
    private String name;
    private int yearBirth;
}
