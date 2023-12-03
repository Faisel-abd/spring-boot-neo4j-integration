package com.trainig.neo4jboot.integration.Controllers;

import com.trainig.neo4jboot.integration.DTO.ActorDTO;
import com.trainig.neo4jboot.integration.service.ActorService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/actors")
public class ActorController {

    private final ActorService actorService;

    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }

    @GetMapping
    public ResponseEntity<?> getAllActors(){
        HttpHeaders responseHeaders = new HttpHeaders();
        List<ActorDTO> actors=this.actorService.findAll();
        return  ResponseEntity.ok().headers(responseHeaders).body(actors);
    }
}
