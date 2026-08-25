package com.myapp.spring.web;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.spring.domain.Movie;
import com.myapp.spring.repository.MovieJdbcRepository;


import lombok.experimental.PackagePrivate;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("api/movies")
public class MovieController {

    private MovieJdbcRepository movieJdbcRepository;

    public MovieController(MovieJdbcRepository movieJdbcRepository) {
        this.movieJdbcRepository = movieJdbcRepository;
    }

   // http://localhost:8080/api/movies/matrix
    @GetMapping("/{movieName}")
    public List<Movie> recommendedMovies(@PathVariable String movieName){

        return movieJdbcRepository.recommendations(movieName);
    }

}
