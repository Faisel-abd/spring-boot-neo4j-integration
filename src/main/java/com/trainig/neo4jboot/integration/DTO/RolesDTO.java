package com.trainig.neo4jboot.integration.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
@Data
@NoArgsConstructor
public class RolesDTO  implements Serializable {

    @JsonIgnore
    private  Long id;
    private  ActorDTO actor;
    private  List<String> roles;
}
