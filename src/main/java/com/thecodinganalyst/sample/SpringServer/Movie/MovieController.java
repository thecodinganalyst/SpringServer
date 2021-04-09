package com.thecodinganalyst.sample.SpringServer.Movie;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@Slf4j
public class MovieController {

    private final MovieRepository movieRepository;

    public MovieController(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }

    @GetMapping
    public Flux<Movie> movieList(){
        log.info("API Execution: /movies");
        return Flux.fromIterable(movieRepository.findAll());
    }
}
