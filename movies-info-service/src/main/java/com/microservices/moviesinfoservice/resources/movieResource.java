package com.microservices.moviesinfoservice.resources;

import com.microservices.moviesinfoservice.models.movie;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class movieResource {

    @RequestMapping("/{movieId}")
    public movie getMovieInfo(@PathVariable("movieId") String movieId) {

        return new movie(movieId, "WAR");
    }
}
