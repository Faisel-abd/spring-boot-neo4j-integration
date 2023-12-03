package com.trainig.neo4jboot.integration.service;

import com.trainig.neo4jboot.integration.DTO.MovieDTO;
import com.trainig.neo4jboot.integration.common.Constants;
import com.trainig.neo4jboot.integration.mapper.MovieMapper;
import com.trainig.neo4jboot.integration.model.Movie;
import com.trainig.neo4jboot.integration.repository.MovieRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class MovieService {

    private final MovieRepository movieRepository;
    private final MovieMapper movieMapper;

    public MovieService(MovieRepository movieRepository, MovieMapper movieMapper){
        this.movieRepository=movieRepository;
        this.movieMapper = movieMapper;
    }

    @Cacheable(value = "movies", key = "#root.methodName")
    public List<MovieDTO> findAll(){
        return this.movieRepository.findAll().stream().map(movieMapper::movieToMovieDTO).collect(Collectors.toList());
    }

    @CacheEvict(value = "movies",allEntries = true)
    public Optional<MovieDTO> addMovie(MovieDTO movieDto){
        MovieDTO movieEntity=null;
        try {
            Movie movie=movieMapper.movieDTOToMovie(movieDto);
            movieEntity=movieMapper.movieToMovieDTO(this.movieRepository.save(movie));
        }catch (DataAccessException dataAccessException){
            log.error(Constants.ERROR_DATA_ACCESS_SAVE,this.getClass().getName(),movieDto.getClass().getName(),dataAccessException);
            return null;
        }
        return Optional.ofNullable(movieEntity);
    }
}
