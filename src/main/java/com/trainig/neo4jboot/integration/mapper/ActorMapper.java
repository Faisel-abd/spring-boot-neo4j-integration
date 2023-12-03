package com.trainig.neo4jboot.integration.mapper;

import com.trainig.neo4jboot.integration.DTO.ActorDTO;
import com.trainig.neo4jboot.integration.model.Actor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface ActorMapper {

    @Mappings({@Mapping(source = "actor.name",target = "name"),
            @Mapping(source="actor.yearBirth",target = "yearBirth")
    })
    ActorDTO actorToActorDTO(Actor actor);

    @Mappings({@Mapping(source = "actorDTO.name",target = "name"),
            @Mapping(source="actorDTO.yearBirth",target = "yearBirth"),
            @Mapping(source="actorDTO.id",target = "id")
    })
    Actor actorDTOToActor(ActorDTO actorDTO);
}
