package com.trainig.neo4jboot.integration.mapper;

import com.trainig.neo4jboot.integration.DTO.ActorDTO;
import com.trainig.neo4jboot.integration.DTO.RolesDTO;
import com.trainig.neo4jboot.integration.model.Actor;
import com.trainig.neo4jboot.integration.model.Roles;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface RolesMapper {

    @Mappings({@Mapping(source = "roles.actor",target = "actor"),
              @Mapping(source = "roles.roles",target = "roles")})
    RolesDTO rolesToRolesDTO(Roles roles);
    ActorDTO actorToActorDTO(Actor actor);

    @Mappings({@Mapping(source = "roles.actor",target = "actor"),
            @Mapping(source = "roles.roles",target = "roles"),
            @Mapping(source = "roles.id",target = "id")})
    Roles rolesDTOToRoles(RolesDTO roles);
    Actor actorDTOToActor(ActorDTO actorDTO);
}
