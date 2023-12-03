package com.trainig.neo4jboot.integration.service;

import com.trainig.neo4jboot.integration.DTO.ActorDTO;
import com.trainig.neo4jboot.integration.mapper.ActorMapper;
import com.trainig.neo4jboot.integration.repository.ActorRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActorService {

    private final ActorRepository actorRepository;
    private final ActorMapper actorMapper;

    public ActorService(ActorRepository actorRepository, ActorMapper actorMapper){
        this.actorRepository=actorRepository;
        this.actorMapper = actorMapper;
    }

    @Cacheable(value = "actors", key = "#root.methodName")
    public List<ActorDTO> findAll(){
      return this.actorRepository.findAll().stream().map(actorMapper::actorToActorDTO).collect(Collectors.toList());
    }
}
