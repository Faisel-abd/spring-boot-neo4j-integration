package com.trainig.neo4jboot.integration.Controllers;

import com.trainig.neo4jboot.integration.DTO.MovieDTO;
import com.trainig.neo4jboot.integration.common.Constants;
import com.trainig.neo4jboot.integration.errorHandler.ResponseError;
import com.trainig.neo4jboot.integration.service.ActorService;
import com.trainig.neo4jboot.integration.service.MovieService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movies")
public class MovieController {


    private final MovieService movieService;
    private final ActorService actorService;

    public MovieController(MovieService movieService, ActorService actorService){
        this.movieService=movieService;
        this.actorService = actorService;
    }

    @GetMapping
    public ResponseEntity<?>  getAllMovies(){
        HttpHeaders responseHeaders = new HttpHeaders();
        List<MovieDTO> movies=this.movieService.findAll();
        return  ResponseEntity.ok().headers(responseHeaders).body(movies);
    }



    @PostMapping
    public ResponseEntity<?>  saveMovie(@Valid @RequestBody MovieDTO movieDTO){
        HttpHeaders responseHeaders = new HttpHeaders();
       Optional<MovieDTO> result= this.movieService.addMovie(movieDTO);
       if(result.isPresent()){
           return  ResponseEntity.ok().headers(responseHeaders).body(result.get());
       }else{
          return
                  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                          .headers(responseHeaders)
                          .body(ResponseError.builder().code(HttpStatus.INTERNAL_SERVER_ERROR.value())
                        .message(Constants.ERROR_GLOBAL_MESSAGE).build());
       }
    }
}
