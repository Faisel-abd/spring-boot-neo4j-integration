package com.trainig.neo4jboot.integration.mapper;

import com.trainig.neo4jboot.integration.DTO.ActorDTO;
import com.trainig.neo4jboot.integration.DTO.MovieDTO;
import com.trainig.neo4jboot.integration.DTO.RolesDTO;
import com.trainig.neo4jboot.integration.model.Actor;
import com.trainig.neo4jboot.integration.model.Movie;
import com.trainig.neo4jboot.integration.model.Roles;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;


@Mapper(componentModel = "spring")
public interface MovieMapper {

    @Mappings({@Mapping(source = "movie.title", target = "title"),
            @Mapping(source = "movie.yearOfRelease", target = "yearOfRelease"),
            @Mapping(source = "movie.shortDescription", target = "shortDescription"),
            @Mapping(source = "movie.directors", target = "directors"),
            @Mapping(source = "movie.actorsAndRoles", target = "actorsAndRoles")})
    MovieDTO movieToMovieDTO(Movie movie);
    ActorDTO actorToActorDTO(Actor actor);
    RolesDTO rolesToRolesDTO(Roles roles);

    @Mappings({@Mapping(source = "movie.id", target = "id"),
            @Mapping(source = "movie.title", target = "title"),
            @Mapping(source = "movie.yearOfRelease", target = "yearOfRelease"),
            @Mapping(source = "movie.shortDescription", target = "shortDescription"),
            @Mapping(source = "movie.directors", target = "directors"),
            @Mapping(source = "movie.actorsAndRoles", target = "actorsAndRoles")})
    Movie movieDTOToMovie(MovieDTO movie);
    Actor actorToActorDTO(ActorDTO actor);
    Roles rolesToRolesDTO(RolesDTO roles);
}
